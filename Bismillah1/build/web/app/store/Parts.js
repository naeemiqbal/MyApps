Ext.define('BISM.store.Parts', {
    extend: 'Ext.data.Store',
    model: 'BISM.model.Part',
    autoLoad: true,
    storeId: 'nmiStore',
    proxy: {
        type: 'ajax',
        url: 'data/Parts.json.js',
        reader: {
            type: 'json',
            rootProperty: 'parts',
            successProperty: 'success'
        }
    }
});



