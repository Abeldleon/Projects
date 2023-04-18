#include <stdexcept>
class null_ptr_exception : public std::runtime_error {
public:
    null_ptr_exception(const char* s) :runtime_error(s) {}
};
template <typename T>
class smart_ptr {
public:
    smart_ptr()noexcept :ptr_(nullptr), ref_(nullptr) {}
    // Create a smart_ptr that is initialized to nullptr. The reference count
    // should be initialized to nullptr.

    explicit smart_ptr(T*& raw_ptr): ptr_(raw_ptr), ref_(new int(1)) {}
    // Create a smart_ptr that is initialized to raw_ptr. The reference count
    // should be one. No change is made to raw_ptr.

    explicit smart_ptr(T*&& raw_ptr): ptr_(raw_ptr), ref_(new int(1)){
        if (ptr_ == nullptr) {
            delete ref_;
        }
    }                                     
    // Create a smart_ptr that is initialized to raw_ptr. The reference count
    // should be one. If the constructor fails raw_ptr is deleted.	

    smart_ptr(const smart_ptr& rhs): ptr_(rhs.ptr_), ref_(rhs.ref_){
        if (ref_) {
            (*ref_)++;
        }
    }
    // Copy construct a pointer from rhs. The reference count should be 
    // incremented by one.

    smart_ptr(smart_ptr&& rhs) noexcept: ptr_(rhs.ptr_), ref_(rhs.ref_) {
        rhs.ptr_ = nullptr;
        rhs.ref_ = nullptr;
    }
    // Move construct a pointer from rhs.

    smart_ptr& operator=(const smart_ptr& rhs) {
        if (this != &rhs) {
            if (ref_ != nullptr) {
                (*ref_)--;
                if (*ref_ == 0) {
                    delete ptr_;
                    delete ref_;
                }
                ptr_ = nullptr;
                ref_ = nullptr;
            }

            ptr_ = rhs.ptr_;
            ref_ = rhs.ref_;
            if (ref_ != nullptr) {
                (*ref_)++;
            }
        }
        return *this;
    }
    // This assignment should make a shallow copy of the right-hand side's
    // pointer data. The reference count should be incremented as appropriate.

    smart_ptr& operator=(smart_ptr&& rhs) noexcept {
        if (this != &rhs) {
            if (ref_ != nullptr) {
                (*ref_)--;
                if (*ref_ == 0) {
                    delete ptr_;
                    delete ref_;
                }
                ptr_ = nullptr;
                ref_ = nullptr;
            }
            ptr_ = rhs.ptr_;
            ref_ = rhs.ref_;
            rhs.ptr_ = nullptr;
            rhs.ref_ = nullptr;
        }
        return *this;
    }
    // This move assignment should steal the right-hand side's pointer data.

    bool clone() noexcept {
        if (ref_ && (*ref_) > 1) {
            T* new_ptr = new T(*ptr_);

            if (ref_ != nullptr) {
                (*ref_)--;
                if (*ref_ == 0) {
                    delete ptr_;
                    delete ref_;
                }
                ptr_ = nullptr;
                ref_ = nullptr;
            }
            ptr_ = new_ptr;
            ref_ = new int(1);
            return true;
        }
        return false;
    }
    // If the smart_ptr is either nullptr or has a reference count of one, this
    // function will do nothing and return false. Otherwise, the referred to
    // object's reference count will be decreased and a new deep copy of the
    // object will be created. This new copy will be the object that this
    // smart_ptr points and its reference count will be one. 

    int ref_count() noexcept const {
        if (ref_ != nullptr) {
            return *ref_;
        }
        else {
            return 0;
        }
    }
    // Returns the reference count of the pointed to data.

    T& operator*() {
        if (ptr_ == nullptr) {
            throw null_ptr_exception("Invalid access");
        }
        return *ptr_;
    }
    // The dereference operator shall return a reference to the referred object.
    // Throws null_ptr_exception on invalid access. 

    T* operator->() {
        if (ptr_ == nullptr) {
            throw null_ptr_exception("Invalid access");
        }
        return ptr_;
    }
    // The arrow operator shall return the pointer ptr_. Throws null_ptr_exception
    // on invalid access.

    ~smart_ptr() noexcept {
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
    // deallocate all dynamic memory
private:
    T* ptr_;               // pointer to the referred object
    int* ref_;             // pointer to a reference count
};