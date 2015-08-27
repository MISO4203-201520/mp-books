(function (ng) {
    var mod = ng.module('bookModule', ['ngCrud']);

    mod.constant('bookContext', 'books');

    mod.constant('bookModel', {
        fields: [{
                name: 'name',
                displayName: 'Name',
                type: 'String',
                required: true
            }, {
                name: 'description',
                displayName: 'Description',
                type: 'String',
                required: true
            }, {
                name: 'image',
                displayName: 'Image',
                type: 'Image',
                required: true
            }, {
                name: 'isbn',
                displayName: 'ISBN-10',
                type: 'String',
                required: true
            },{
                name: 'publicationDate',
                displayName: 'Publication Date',
                type: 'Date',
                required: true
            }]});
})(window.angular);
