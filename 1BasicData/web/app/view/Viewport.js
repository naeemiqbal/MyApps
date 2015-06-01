Ext.define('BISM.view.Viewport', {
    extend: 'Ext.container.Viewport',
    layout: 'border',
    requires: ['BISM.view.parts.Edit', 'BISM.view.parts.List'],
    items: [
        {
            xtype: 'panel',
            region: 'north',
            html: 'The future Menu Bar goes here',
            split: true,
//            collapsible: true
        },
        {
            xtype: 'panel',
            region: 'west',
            html: 'Side Bar',
            split: true,
            collapsible: true,
            collapsed : true
        },
        {
            xtype: 'panel',
            region: 'center',
            items: [
                {                    xtype: 'partslist'               }
                //{                   xtype: 'partsedit'                }
            ]
        }
    ]
});

