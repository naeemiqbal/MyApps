Ext.define('BISM.model.Part',{
    extend: 'Ext.data.Model',
    requires: 'Ext.data.reader.Json',
    fields:['partid','partdesc', {name: 'productiondate', type: 'date'}],
    validations: [{type: 'presence', field: 'partid'}]       
});