(function (ng) {
    var mod = ng.module('editorialModule', ['ngCrud']);

    mod.constant('editorialContext', 'editorials');

    mod.constant('editorialModel', {
        fields: [{
                name: 'name',
                displayName: 'Name',
                type: 'String',
                required: true
            }, {
                name: 'email',
                displayName: 'Email',
                type: 'String',
                required: true
            }, {
                name: 'phone',
                displayName: 'Phone',
                type: 'String',
                required: true
            }, {
                name: 'userId',
                displayName: 'UserId',
                type: 'String',
                required: true
            }]});
})(window.angular);
