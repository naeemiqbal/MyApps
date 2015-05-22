Ext.define('BISM.view.Viewport', {
    extend: 'Ext.container.Viewport',
    layout: 'border',
    requires: ['BISM.view.parts.Edit', 'BISM.view.parts.List', 'BISM.view.misc.SideButton'],
    items: [
        {
            xtype: 'panel',
            region: 'north',
            //html: 'The future Menu Bar goes here',
            split: true,
            items : [ 
                { xtype: 'button', text: 'Main Menu', items: [{ text: 'One'}]},
                { xtype: 'menu',
                    items: [{ text: 'Item1'},
                        { text: 'Item2'},
                        { text: 'Item3'}
                    ]                    
            }],
            layout: 'hbox'
//            collapsible: true
        },
        {
            xtype: 'panel',
            region: 'west',
            title: 'Side Bar',
            split: true,
            collapsible: true,
            collapsed: false,
            width: 100,
            items: [{xtype: 'twobutton', text: 'Two', action: 'opentwo', itemId: 'b_two'},
                {xtype: 'twobutton', text: 'Three', action: 'openthree'},
                {xtype: 'twobutton', text: 'Four', action: 'openfour' , destroy: function() { alert("four destroy");} },
                {xtype: 'twobutton', text : 'Parts List', itemId: 'b_partslist', action : 'openone', disabled : true }            
            ]
        },
        {
            xtype: 'panel',
            region: 'center',
            itemId: 'mainpage',
            items: [
                {xtype: 'partslist'}
            ]
        }
    ]
});

