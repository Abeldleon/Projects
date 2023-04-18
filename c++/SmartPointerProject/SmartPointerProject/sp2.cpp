#include <stdexcept>
class null_ptr_exception : public std::runtime_error {
public:
    null_ptr_exception(const char* s) :runtime_error(s) {}
};
template <typename T>
class smart_ptr {
public:
    smart_ptr() noexcept :ptr_(nullptr), ref_(nullptr) {}

    explicit smart_ptr(T*& raw_ptr) : ptr_(raw_ptr), ref_(new int(1)) {}

    explicit smart_ptr(T*&& raw_ptr) : ptr_(raw_ptr), ref_(new int(1)) {
        if (ptr_ == nullptr) {
            delete ref_;
        }
    }

    smart_ptr(const smart_ptr& rhs) : ptr_(rhs.ptr_), ref_(rhs.ref_) {
        if (ref_) {
            (*ref_)++;
        }
    }

    smart_ptr(smart_ptr&& rhs) noexcept : ptr_(rhs.ptr_), ref_(rhs.ref_) {
        rhs.ptr_ = nullptr;
        rhs.ref_ = nullptr;
    }

    smart_ptr& operator=(const smart_ptr& rhs) {
        if (this != &rhs) {
            release();
            ptr_ = rhs.ptr_;
            ref_ = rhs.ref_;
            if (ref_ != nullptr) {
                (*ref_)++;
            }
        }
        return *this;
    }

    smart_ptr& operator=(smart_ptr&& rhs) noexcept {
        if (this != &rhs) {
            release();
            ptr_ = rhs.ptr_;
            ref_ = rhs.ref_;
            rhs.ptr_ = nullptr;
            rhs.ref_ = nullptr;
        }
        return *this;
    }

    bool clone() noexcept {
        if (ref_ && (*ref_) > 1) {
            T* new_ptr = new T(*ptr_);
            release();
            ptr_ = new_ptr;
            ref_ = new int(1);
            return true;
        }
        return false;
    }

    int ref_count() noexcept const {
        if (ref_ != nullptr) {
            return *ref_;
        }
        else {
            return 0;
        }
    }

    T& operator*() {
        if (ptr_ == nullptr) {
            throw null_ptr_exception("Invalid access");
        }
        return *ptr_;
    }

    T* operator->() {
        if (ptr_ == nullptr) {
            throw null_ptr_exception("Invalid access");
        }
        return ptr_;
    }

    ~smart_ptr() noexcept {
        release();
    }

private:
    T* ptr_;               
    int* ref_;             

    void release() noexcept {
        if (ref_ != nullptr) {
            (*ref_)--;
            if (*ref_ == 0) {
                delete ptr_;
                delete ref_;
            }
            ptr_ = nullptr;
            ref_ = nullptr;
        }
    }
};