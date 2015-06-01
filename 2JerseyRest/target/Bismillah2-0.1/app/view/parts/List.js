var nmiS = Ext.create('BISM.store.Parts', {
    storeId: 'nmiStore'
});


Ext.define('BISM.view.parts.List', {
    extend: 'Ext.grid.Panel',
    alias: 'widget.partslist',
    //store: 'Parts',
    store: Ext.data.StoreManager.lookup('nmiStore'),
    columns: [
        {header: 'Part ID', dataIndex: 'partid'},
        {header: 'Description', dataIndex: 'partdesc', width: 300},
        {header: 'Production Date', dataIndex: 'productiondate', width: 200, xtype: 'datecolumn'}
    ],
    tbar: [
        {xtype: 'button', action: 'add', text: 'Add'},
        {xtype: 'button', action: 'delete', text: 'Delete'},
        {xtype: 'button', action: 'update', text: 'Update'},
        {xtype: 'button', action: 'get', text: 'Reload'}
    ]
});