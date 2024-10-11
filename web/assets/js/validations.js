const formRegister = document.querySelector('.formRegister');
if (formRegister) {
    formRegister.addEventListener('submit', (e) => {
        e.preventDefault();

        const fullName = formRegister.querySelector('#fullname').value;
        const email = formRegister.querySelector('#email').value;
        const password = formRegister.querySelector('#password').value;
        const passwordConfirmation = formRegister.querySelector('#password_confirmation').value;
        
        if(minLength(fullName) !== true) {
            new Notify({
                title: 'Thất bại!',
                text: "Họ và tên phải lớn hơn 8 kí tự!",
                status: 'error',
                effect: 'slide',
                speed: 300,
                timeout: 1500,
                customClass: 'notify-error' // Tùy chỉnh lớp CSS nếu cần
            });
            return; 
        }
        
        if (isEmail(email) !== true) {
            new Notify({
                title: 'Thất bại!',
                text: isEmail(email),
                status: 'error',
                effect: 'slide',
                speed: 300,
                timeout: 1500,
                customClass: 'notify-error' // Tùy chỉnh lớp CSS nếu cần
            });
            return; 
        }
        
        if(checkPass(password) !== null) {
            new Notify({
                title: 'Thất bại!',
                text: checkPass(password),
                status: 'error',
                effect: 'slide',
                speed: 300,
                timeout: 1500,
                customClass: 'notify-error' // Tùy chỉnh lớp CSS nếu cần
            });
            return; 
        }

        if (password !== passwordConfirmation) {
            new Notify({
                title: 'Thất bại!',
                text: "Mật khẩu không khớp!",
                status: 'error',
                effect: 'slide',
                speed: 300,
                timeout: 1500,
                customClass: 'notify-error' // Tùy chỉnh lớp CSS nếu cần
            });
            return; 
        }
        
        formRegister.submit();

    });
}

function isEmail(value) {
    var regex = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
    return regex.test(value) ? true : "Trường này phải là email!";
}

function minLength(value) {
    return value.length > 8 ? true : false;
}

function checkPass(value) {
    var p = value;
    var errors = [];
    if (p.length < 8) {
        errors.push('Mật khẩu của bạn phải có ít nhất 8 ký tự.');
    }
    if (p.search(/[a-z]/i) < 0) {
        errors.push('Mật khẩu của bạn phải chứa ít nhất một chữ cái.');
    }
    if (p.search(/[0-9]/) < 0) {
        errors.push('Mật khẩu của bạn phải chứa ít nhất một chữ số.');
    }
    if (p.search(/[^a-zA-Z0-9]/) < 0) {
        errors.push('Mật khẩu của bạn phải chứa ít nhất một ký tự đặc biệt.');
    }
    
    return errors.length > 0 ? errors.join('<br>') : null;
}