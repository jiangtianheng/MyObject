var Validator = {

    minSize: null,

    maxSize: null,

    errors: [],

    isValid: function (string, validationArray) {
        var self = this;
        var valid = true;
        self.errors = [];

        for(var i = 0; i < validationArray.length; i++){
            switch(validationArray[i]){
                case 'is_empty':
                    if(self.isEmpty(string)){
                        self.errors.push('is_empty');
                        valid = false;
                    }
                    break;
                case 'is_xss':
                    if(self.isXss(string)){
                        self.errors.push('is_xss');
                        valid = false;
                    }
                    break;
                case 'is_too_large':
                    if(self.isTooLarge(string)){
                        self.errors.push('is_too_large');
                        valid = false;
                    }
                    break;
                case 'is_too_short':
                    if(self.isTooShort(string)){
                        self.errors.push('is_too_short');
                        valid = false;
                    }
                    break;
                case 'is_not_selected_file':
                    if(self.isNotSelectedFile(string)){
                        self.errors.push('is_not_selected_file');
                        valid = false;
                    }
                    break;
                case 'is_not_number':
                    if(self.isNotNumber(string)){
                        self.errors.push('is_not_number');
                        valid = false;
                    }
                    break;
            }
        }
        self.clearRestrictions();

        return valid;
    },
    isEmpty: function (string) {
        var notValid = false;

        if(string.localeCompare('') === 0){
            notValid = true;
        }
        return notValid;
    },
    isXss: function (string) {
        var notValid = false;

        if(string.indexOf('<script>') !== -1){
            notValid = true;
        }
        if(string.indexOf('</script>') !== -1){
            notValid = true;
        }
        return notValid;
    },
    isTooLarge: function (string) {
        var notValid = false;
        if(string.length > this.maxSize){
            notValid = true;
        }
        return notValid;
    },
    isTooShort: function (string) {
        var notValid = false;
        if(string.length < this.minSize){
            notValid = true;
        }
        return notValid;
    },
    isNotSelectedFile: function (file) {
        var notValid = false;
        if(!file){
            notValid = true;
        }
        return notValid;
    },
    isNotNumber: function (string) {
        var notValid = false;
        var regularExp = /[a-zA-Zа-яА-ЯЁё'"^£$%&*()}{@#~?><>,|=_+¬-]+/iu;
        if(string.search(regularExp) !== -1){
            notValid = true;
        }
        return notValid;
    },
    clearRestrictions: function () {
        this.minSize = null;
        this.maxSize = null;
    }
};
