/*
	Copyright (c) 2004-2009, The Dojo Foundation All Rights Reserved.
	Available via Academic Free License >= 2.1 OR the modified BSD license.
	see: http://dojotoolkit.org/license for details
*/


if(!dojo._hasResource["aas.container.Table"]){ //_hasResource checks added by build. Do not use _hasResource directly in your code.
dojo._hasResource["aas.container.Table"] = true;
dojo.provide("aas.container.Table");
dojo.require("aas.data.cookie");
dojo.require("dijit._Widget");
dojo.require("dijit._Templated");
dojo.require("dijit.Tooltip");
dojo.require("dojo.data.ItemFileWriteStore");
dojo.require("dijit.form.ComboBox");
/**
 * Defines the aas.container.Table widget, which displays a (possibly lazy)
 * store as a paginated, sortable table.
 */
dojo.declare("aas.container.Table", [dijit._Widget, dijit._Templated], {
  templateString:"<div class=\"tableWidget\">\r\n\t<table dojoAttachPoint=\"aasTable\">\r\n\t\t<thead class=\"tableWidgetHeader\" dojoAttachPoint=\"aasTableHeader\"></thead>\r\n\t\t<tbody class=\"tableWidgetBody\" dojoAttachPoint=\"aasTableBody\"></tbody>\r\n\t</table>\r\n\t<div class=\"pageIndex\">\r\n\t<div class=\"actionButtons\" dojoAttachPoint=\"aasTableActionButtons\"> </div>\r\n\t<div dojoAttachPoint=\"aasTablePageIndex\"> </div>\r\n\t</div>\r\n</div>\r\n",

  /**
   * Construct a new Table object.
   *
   * @param parameters
   *            Hash with parameters:
   *            <ul>
   *            <li> store: The store object to draw data from. This can be
   *                 lazy or not, but if lazy, the loadStorePage function must
   *                 be passed as a parameter.
   *            <li> header: Array of headers (row definitions), each a hash
   *                 of:
   *                 <ul>
   *                 <li> title: Title of the row, as fully escaped HTML
   *                 <li> name: Internal name of the column in the store.
   *                 <li> valueHandler: A function that formats the contents of
   *                      a table cell. This is called whenever an element of
   *                      an item is added to the table. If no valueHandler
   *                      is given, the defaultValueHandler is used instead.
   *                      Parameters:
   *                     <ul>
   *                      <li> value: An object or an array of objects
   *                           containing the actual data of the element.
   *                      <li> itemId: An identity into the store identifying
   *                           the item whose values arebeing added. This is the
   *                           unique identifier of the item in the store.
   *                      <li> item: The item in the store whose values are
   *                           being added.
   *                      </ul>
   *                 <li> isSortable: Whether the user can click the header of
   *                      this column to sort by the column's values. This will
   *                      probably be the only option for user-defined columns
   *                      in the future.
   *                 <li> hasFilter: Whether a filter box will be shown for
   *                      this column. Default true.
   *                 <li> sortColumn: Which column of the store to sort by, if
   *                      not this one. This is a name of a column as defined
   *                      above.
   *                 </ul>
   *            <li> reloadStore: A function to reload the store with a new
   *                 sort.  A non-complete store may choose to only reload the
   *                 current page.  This function must *set* the store on the
   *                 Table object. Parameters are:
   *                 <ul>
   *                 <li> sortColumns: An array of {String attribute, boolean
   *                      descending} indicating the columns to sort by, in
   *                      order, and whether to sort ascending or descending.
   *                 </ul>
   *                 In the future, startIndex and endIndex may be added
   *            <li> isMultiSortable: If true, the table will support sorting
   *                 by multiple columns.
   *            <li> getClass: If given, is added to each row as a CSS class.
   *            <li> isStoreComplete: If true, the store holds all entries
   *                 internally, otherwise the loadStorePage
   *                 function must be given here or passed along with
   *                 setStore to handle loading items into the store.
   *            <li> defaultValueHandler:  The function is used where the
   *                 header parameter does not define one.  See definition
   *                 of valueHandler in the headers parameter.
   *            <li> loadStorePage
   *                 A function that, if given, will be used to force the store
   *                 to read pages, if you want to do handling outside of
   *                 the normal fetch() call to the store.  This function should
   *                 call show() once the data are present.
    *                 This can also be passed along to setStore. Parameters:
   *                 <ul>
   *                 <li> startIndex: Index into the store to start at.
   *                 <li> pageSize: How many elements to get at a time.
   *                 </ul>
   *            <li> pageSizes: Selection of possible items per page to allow
   *                 in the dropdown.  If null or not given, no pagination is
   *                 done. If an array of integers, those are the allowed
   *                 values, with the first one the default.  Otherwise, a
   *                 reasonable default set is used.
   *            <li> filter: Function to apply filters entered by the
   *                 user.  If not given, no filter columns are shown.
   *                 Parameters:
   *                 <ul>
   *                 <li> request: The current request, which should be updated
   *                      with the filtering info and returned.
   *                 <li> filter: Hash from column name (as given in the headers
   *                      parameter) to a string with '*'/'?' wildcards that
   *                      should be matched against the full column string.
   *                      Note that the
   *                      text entered in the filter box will be surrounded by
   *                      '*' before being passed to this function.
   *                 Must return an updated request that handles the filters.
   *            <li> filterChoices: Either a map from column name to list of
   *                 strings or a URL of a JSON call that returns such a
   *                 map. Each entry specifies the choices available for
   *                 the column, that column will then have a drop-down
   *                 (as well as a text entry) that contains these choices.
   *            </ul>
   *            <li> actions: List of actions that should be available through
   *                 buttons, working on selected items.  Array of hashes:
   *                 <ul>
   *                 <li> title: The HTML that will be displayed in the button.
   *                 <li> callback: A function that will be called with an
   *                      object mapping item IDs to items and a progress
   *                      callback when the button is pressed.  The progress
   *                      callback should be called with an item id and either
   *                      null (to remove progress indicator), a percentile
   *                      number, a string, or a DOM object
   *								 <li> column: Optional, a column that the action should be
   *                      placed under. If not given, the action just floats to
   *                      the left and is placed below the line.
   *                 <li> global: Optional, if given no checkboxes are shown.
   *                 <li> enable: Optional, a function that given the list of
   *                      selected items returns whether the action button should
   *                      be enabled.
   *                 </ul>
   *            <li> selectValueHandler: A function to modify the check button
   *                 used to select items for actions.  Arguments:
   *                 <ul>
   *                 <li> checkbox: A checkbox DOM element that will be inserted
   *                      in the table.
   *                 <li> itemId: The ID of the current item.
   *                 <li> item: The current item.
   *                 </ul>
   *                 Must return a DOM element to insert in the select column,
   *                 typically the one given.
   *            <li> persist: A unique name for persisting various state for
   *                 the table (filters, itemsperpage).
   *            <li> initialSort: An object {String columnName, boolean sortDescending}
   *                 that specifies the initial sort method.  The caller is
   *                 responsible for the sort correspondingly happening in the
   *                 store.
   *            <li> multiPageSelect: If true, rows can be selected that are not
   *                 currently shown. A count of the invisible selected rows
   *                 is displayed at the top. Default false.
   *            </ul>
   */
  constructor : function(/* Object */parameters) {
    lang.requireBundle("table");
    var self = this;

    this.store = parameters.store;
    this._header = parameters.header;
    this._headerTitleAttr = "title";
    this._contentIdentifierAttr = "name";
    this._dataAttr = "items";
    this._filterAttr = "filter";
    this._identifiers = [];
    this._currentIndex = undefined;
    this._currentRequest = {};
    if (parameters.valueHandlers) {
      throw new Error("Please don't pass in value handlers outside of headers");
    }
    if (parameters.defaultValueHandler) {
      this.defaultValueHandler = parameters.defaultValueHandler;
    }
    this._reloadStore = parameters.reloadStore;
    this._insertItemListeners = [];
    this._sortMap = {};
    this._headerMap = {};
    console.log("parameters.store " + parameters.store);
    console.log("\n parameters.header " + parameters.header);
    console.log("\n parameters.header " + parameters.header);
    console.log("\n parameters.valueHandlers " + parameters.valueHandlers);
    console.log("\n parameters.reloadStore " + parameters.reloadStore);
    console.log("\n parameters.initialSort " + parameters.initialSort);
    console.log("\n parameters.isMultiSortable " + parameters.isMultiSortable);
    console.log("\n parameters.getClass " + parameters.getClass);
    console.log("\n parameters.loadStorePage " + parameters.loadStorePage);
    console.log("\n parameters.filterChoices " + parameters.filterChoices);
    console.log("\n parameters.header " + parameters.selectValueHandler);
    console.log("\n parameters.isStoreComplete " + parameters.isStoreComplete);
    console.log("\n parameters.persist " + parameters.persist);
    if (parameters.initialSort) {
      this.sort = parameters.initialSort;
    } else {
      this.sort = [];
    }
    this._isMultiSortable = parameters.isMultiSortable;
    this.getClass = parameters.getClass;
    this._loadStorePage = parameters.loadStorePage;
    this._possiblePageSizes = [];
    if (parameters.pageSizes) {
      if (parameters.pageSizes instanceof Array) {
        this._possiblePageSizes = parameters.pageSizes;
      } else {
        this._possiblePageSizes = [ 20, 50, 100, 500 ];
      }
      this._currentItemsPerPage = this._possiblePageSizes[0];
    } else {
      // No pagination
      this._currentItemsPerPage = null;
    }
    if (parameters.filter) {
      this._filter = parameters.filter;
      this._filters = {};
      if (false && parameters.filterChoices) {
        if (typeof(parameters.filterChoices) == "string") {
          // An URL for fetching choices data
          this._filterChoices = "fetching"; // remember that we are fetching
          var getArgs = {
            url: parameters.filterChoices,
            sync: false,
            handleAs: "json-comment-optional"
          };
          var getHandler = dojo.xhrGet(getArgs);
          getHandler.addCallback(function(data) {
        	  console.log("Passing data to callBack Functtion....."+data);
            self._filterChoices = data;
            self._updateFilterChoices();
          });
          getHandler.addErrback(function(error) {
            self._filterChoices = undefined;
          });
        } else {
          this._filterChoices = parameters.filterChoices;
        }
      }
    }
    if (parameters.selectValueHandler) {
      this._selectValueHandler = parameters.selectValueHandler;
    }
    if (parameters.actions && parameters.actions.length > 0) {
      this._actions = parameters.actions;
    }

    this._multiPageSelect = parameters.multiPageSelect === true;
    // If we have all the data needed, we do not have to contact the server
    // when sorting
    this.isStoreComplete = (parameters.isStoreComplete === false)
        ? false
        : true;

    this._valueHandlers = {};
    this._sortIconClasses = ["tableSortAsc", "tableSortDesc"];
    this._sortHeaders = {};
    this._headerSortIcons = [];
    this._lastItemCount = 0; // Count of items fetched.
    // Map from item ID to current progress (DOM element)
    this._keepOldProgress = ( ! parameters.resetProgress);
    this._itemProgresses = {};
    // Map from item ID to cell showing current progress, updated in _addItem
    this._itemProgressCells = {};
    this._toggleAllState = false; // Whether the "toggle all" button turns on or off
    if (parameters.persist) {
      this._persistName = parameters.persist;
      dojo.mixin(this, aas.data.cookie.restore(this._persistName));
      if (this._filter) {
        this._currentRequest = this._filter(this._currentRequest, this._starifyFilters(this._filters));
      }
    }
  },

  /** Called after the object has been created. */
  postCreate : function() {
    this.inherited("postCreate", arguments);
    var self = this;

    this._createHeader();
  },

  _persist : function() {
    if (this._persistName) {
      if (this._filters) {
        aas.data.cookie.save(this._persistName, this,
          [ "_filters", "_currentItemsPerPage" ]);
      } else {
        aas.data.cookie.save(this._persistName, this,
          [ "_currentItemsPerPage" ]);
      }
    }
  },

  /**
   * Add a listener for when items are inserted into the table.
   *
   * @param listener
   *            A function that will be called each time an item is added,
   *            which happens every time the table is shown or the user go to
   *            a new page. Parameters:
   *            <ul>
   *            <li> row: A DOM element containing the formatted table row.
   *            <li> item: An item (row) fetched from the store.
   *            </ul>
   */
  addInsertItemListener : function(/* function */listener) {
    this._insertItemListeners.push(listener);
  },

  _getItemId : function(/* store-item */ item) {
    try {
      var itemId = this.store.getIdentity(item);
      if (typeof(itemId) != "string") {
        itemId = itemId.toString();
      }
    } catch (e) {
      throw new Error("Item " + item + " has no identity attribute: " + e);
    }
    return itemId;
  },

  /** The styles used to generate shading for rows.
   * Having six styles allows every-other shading or groups-of-three shading. */
  _styles: ["row1", "row2", "row3", "row4", "row5", "row6"],

  /**
   * Renders the table by inserting all items in the given range.
   *
   * @param startIndex
   *            The item number to start displaying at
   * @param itemsPerPage
   *            How many items to show on a page
   * @param request
   *            A request for the store to extract items with, as defined in
   *            the dojo.data.api.Read API.  If the request includes a sort
   *            object, it will be stored in the table and modified as the
   *            user changes sort columns.
   * @param onComplete
   *            (optional) Function that will be called after items have been
   *            fetched and processed. Parameters:
   *            <ul>
   *            <li> items Items as fetched from the store. There may be more
   *                 items than are displayed in the table. Only the items from
   *                 startIndex to startIndex + itemsPerPage will be displayed.
   *            <li> self The table object.
   *            </ul>
   * @param opt:
   *            Unused.
   * @param retry:
   *            If true, we will retry fetching data from the store once in
   *            case of error.
   */
  show : function( /* number */startIndex,
                   /* ignored number */	itemsPerPage,
                   /* Object ? */ request,
                   /* function ? */onComplete,
                   /* Object ? */opt,
                   /* boolean */ retry) {
  //  var startIndex = (parameters.startIndex?parameters.startIndex:0);
	  console.log("========show()======== ");	  
    if (!startIndex) {
      startIndex = 0;
    }
    this.clearTable();
    this._showAlert(lang.table.loading);
    this._itemProgressCells = {};
    this._currentIndex = startIndex;
    if (request) {
      this._currentRequest = request;
      // Initialize or override our sort data
      if (request.sort !== undefined) {
        this.sort = request.sort;
      } else {
        request.sort = this.sort;
      }
    } else {
      request = this._currentRequest;
    }
    var self = this;
    var itemsPerPage = this._currentItemsPerPage;
    var fetchRequest = {};
    dojo.mixin(fetchRequest, request);
    fetchRequest.sort = self.sort;
    fetchRequest.start = startIndex;
    fetchRequest.count = itemsPerPage;
    console.log("requirecheckboxes..."+_requiresCheckboxes());
    fetchRequest.onBegin = function(size, request) {
      self._lastItemCount = size;
    };
    
    fetchRequest.onComplete = function(items, request) {
    	console.log("onComplete.itemslist.."+items);
      self._showAlert(null);
      if (items.length === 0) {
        self._showAlert(lang.table.noItems);
      }
      self._selectButtons = {};
      if (self._requiresCheckboxes()) {
        self._toggleAllState = true; // When items are freshly added, all are selected
        self._makeToggleAllLink();
      }
      var index = 0;
      for (var item in items) {
        self._addItem(items[item], self._styles[index++ % 6]);
      };
      self._createActionButtons();
      if (itemsPerPage !== null) {
        self._createPager();
      }
      if (onComplete) {
        onComplete(items, self);
      }
    };
    fetchRequest.onError = function(error, request) {
      if (retry !== false) {
        self.show(startIndex, itemsPerPage, this._currentRequest, onComplete, opt, false);
      } else {
        var response = eval(error.responseText);
        if (response && response.error && response.error.badfilter) {
          var column = response.error.badfilter;
          if (self._headerMap[column]) {
            column = self._headerMap[column][self._headerTitleAttr];
          }
          self._showAlert(lang.format(lang.table.badFilterError, column, response.error.badfiltertext));
        } else {
          self._showAlert(lang.table.lookupError);
        }
      }
    };
    this.store.fetch(fetchRequest);
  },

  /** Update the line for a single item, if it is currently shown in the table.
   * This requires an identityEquals method on the store, which will return
   * true if the two given objects are the same identity.
   *
   * @param itemId Id of an item.
   */
  updateItem : function(itemId) {
    var self = this;

    for (var rowIndex in this.aasTableBody.childNodes) {
      var row = this.aasTableBody.childNodes[rowIndex];
      //identityEquals expects two strings
      if (row.itemid && this.store.identityEquals(itemId+"", row.itemid)) {
        var item = self.store.fetchItemByIdentity({identity: itemId,
          onItem : function(item) {
            var newRow = self._createItem(item);
            // Reassign row class
            for (var style in self._styles) {
              if (dojo.hasClass(row, self._styles[style])) {
                dojo.addClass(newRow, self._styles[style]);
              }
            }
            row.parentNode.replaceChild(newRow, row);
          },
          onError : function(error) {
            console.log("Error fetching item " + itemId + ": " + error);
          }});
        break; // Found it, no need to continue
      }
    }
  },

  /**
   * Add an item to the table. This should only be called from show(). After
   * the item has been added to the table, all insertListeners will be called.
   *
   * @param item
   *            An item fetched from the store
   * @param style
   *            A CSS class name for the style of this row
   */
  _addItem : function(item, style) {
    var row = this._createItem(item, style);

    this.aasTableBody.appendChild(row);

    // Notify listeners about the new row
    dojo.forEach(this._insertItemListeners, function(handler) {
      handler(row, item);
    });
  },

  /** If true, there are actions that the user should be allowed to select
   * which boxes to apply to.
   */
  _requiresCheckboxes: function() {
	  console.log("requireCheckboxes check..."+_actions);
    for (var i in this._actions) {
    	console.log("requireCheckboxes check. _actions[i].."+_actions[i]+"     _actions[i].global   "+_actions[i].global);
      if (!this._actions[i].global) {
        return true;
      }
    }
    return false;
  },

  _hasColumnActions: function() {
    return this._requiresCheckboxes();
  },

  _createItem : function(item, style) {
    var row = document.createElement("tr");
    var itemId = this._getItemId(item);
    row.itemid = itemId;
    if (this._hasColumnActions()) {
      var cell = document.createElement("td");
      cell.align = "center";
      var select = document.createElement("input");
      select.type = "checkbox";
      select.defaultChecked = true;
      if (this._selectValueHandler) {
        select = this._selectValueHandler(select, itemId, item);
      }
      select.actionItemId = itemId;
      select.actionItem = item;
      select.onclick = function() { self._updateButtonsEnabled(); };
      this._selectButtons[itemId] = select;
      cell.appendChild(select);
      row.appendChild(cell);

      cell = document.createElement("td");
      dojo.addClass(cell, 'tableProgress');
      if (this._itemProgresses[itemId]) {
        cell.appendChild(this._itemProgresses[itemId]);
      }
      this._itemProgressCells[itemId] = cell;
      row.appendChild(cell);
    } else {
      row.appendChild(document.createElement("td")); // Select column
      row.appendChild(document.createElement("td")); // Progress column
    }

    var identifiers = this._identifiers;
    var self = this;
    /**
     * Create a single table data element in the table.
     *
     * @param i
     *            Identifier of the column to add an element for.
     */
    dojo.forEach(identifiers, function(i) {
      var col = document.createElement("td");
      dojo.addClass(col, "column");
      var value = item[i];
      var content;

      if (self._valueHandlers[i]) {
        var header = self._headerMap[i];
        if (value && value.length > 0) {
          value = header.isArray ? value : value[0];
        } else {
          value = null;
        }
        content = self._valueHandlers[i](value, itemId, item);
      } else {
        content = self.defaultValueHandler(value, itemId, item);
      }
      if (content) {
        if (content.domNode) { // If we're dealing with a dojo widget,
          // insert the dom node
          col.appendChild(content.domNode);
        } else { // Otherwise, assume we're given a dom node or a
          // string
          if (typeof content === "string") {
            col.appendChild(document.createTextNode(content));
          } else {
            col.appendChild(content);
          }
        }
      }
      row.appendChild(col);
    });

    if (style !== undefined) {
      dojo.addClass(row, style);
    }
    if (self.getClass) {
      dojo.addClass(row, self.getClass(item));
    }
    return row;
  },

  /** A default value handler for those columns where no valueHandler has been
   * specified.  This can be overridden by setting the function or by passing
   * the defaultValueHandler parameter to the constructor.
   * @param values An object or array of objects found in the store for this
   *               table cell.
   * @param itemId  An identity into the store identifying the item whose value
   *                is being added. This is the unique identifier of the item
   *                in the store.
   * @param item The item from the store itself
   * @returns A DOM object to insert into the table cell.
   */
  defaultValueHandler : function(value, itemId, item) {
    return document.createTextNode(value ? value : "-");
  },

  /** Get the total number of items displayed, including following pages.
   * This does not include items that are currently filtered out.
   * @returns Number of items
   */
  _getSize : function() {
    return this._lastItemCount;
  },

  _createActionButtons : function() {
    this._actionButtons = {};
    this._createColumnActions();
    this._createGlobalActions();
    this._updateButtonsEnabled();
  },

  _createColumnActions : function() {
    var hasColumnActions = false;
    var columnActions = {};
    for (var action in this._actions) {
      if (this._actions[action].column) {
        columnActions[this._actions[action].column] = this._actions[action];
        hasColumnActions = true;
      }
    }
    if (hasColumnActions) {
      var row = document.createElement("tr");

      var self = this;
      row.appendChild(document.createElement("td")); // Select toggle column
      row.appendChild(document.createElement("td")); // Progress column
      for (var header in this._header) {
        var h = this._header[header];
        var column = h[this._contentIdentifierAttr];
        var action = columnActions[column];
        var td = document.createElement("td");
        if (action) {
          var button = this._createActionButton(action);
          td.appendChild(button);
        }
        row.appendChild(td);
      }
      this.aasTableBody.appendChild(row);
    }
  },

  /** Create action buttons for the defined actions in the aasTableActionButtons
   * area.  Each button will call its respective callback with all items
   * selected.
   */
  _createGlobalActions : function() {
    var buttonArea = this.aasTableActionButtons;
    aas.util.Util.clearElement(buttonArea);
    var self = this;
    dojo.forEach(this._actions, function(action) {
      if (!action.column) {
        var button = self._createActionButton(action);
        buttonArea.appendChild(button);
      }
    });
  },

  _createActionButton : function(action) {
     var button = document.createElement("input");
     button.type = "button";
     button.value = action.title;
     var self = this;
     // Add progress column?
     button.onclick = function(event) {
       var selected = {};
       //Check if there was previous Progress Items
       for (var itemId in self._itemProgresses) {
         if (self._selectButtons[itemId]) {
           // This is new Action we should remove the old Progress Item
           // the IE fails in _createItem if we use appendChild with an old progress item
           if ( ! self._keepOldProgress) {
               self._removeProgressCell(itemId);
           }
         }
       }
       for (var itemId in self._selectButtons) {
         var select = self._selectButtons[itemId];
         if (select.checked) {
           selected[itemId] = select.actionItem;
           // Replace progress container with new one to avoid clashes between
           // old and new progresses on an item.
           var cell = document.createElement("td");
           dojo.addClass(cell, 'tableProgress');
           var oldCell = self._itemProgressCells[itemId];
           oldCell.parentNode.replaceChild(cell, oldCell);
           self._itemProgressCells[itemId] = cell;
           self._updateProgressCell(itemId, document.createTextNode(""));
         }
       }
       self._updateButtonsEnabled();
       action.callback(selected, function(itemId, progress) {
         //console.log(' -- ' + itemId + ' - ' + progress);
         if (progress === null || progress === undefined || progress === "") {
           self._removeProgressCell(itemId);
         } else if (typeof progress === "int" || typeof progress === "Int") {
           self._updateProgressCell(itemId, self._makeProgressElement(progress));
         } else if (typeof progress === "float" || typeof progress === "Float" ||
                    typeof progress === "number" || typeof progress === "Number") {
           self._updateProgressCell(itemId,
             self._makeProgressElement(Math.floor(progress)));
         } else if (typeof progress === "String" || typeof progress == "string") {
           self._updateProgressCell(itemId, document.createTextNode(progress));
         } else {
           self._updateProgressCell(itemId, progress);
         }
       });
     };
     this._actionButtons[action.title] = button;

     return button;
  },

  /** Creates a DOM element showing progress of an action.  It is a div
   * with the class "tableProgressMeter". This could be styled to have some
   * nice color moving across of so desired.
   * @param progress The progress as an integer percentage.  It will be silently
   * clamped to [0, 100].
   * @returns A DOM element showing the percentage.
   */
  _makeProgressElement : function (/* int */ progress) {
     if (progress < 0) { progress = 0; }
     if (progress > 100) { progress = 100; }
     var div = document.createElement("div");
     dojo.addClass(div, "tableProgressMeter");
     div.style.width = "3em";
     div.appendChild(document.createTextNode(progress + " %"));
     return div;
  },

  /** Updates an action progress cell for an item.
   * @param itemId A store-defined identifier for an item.
   * @param domObj A DOM object displaying the progress in some way.
   */
  _updateProgressCell : function (itemId, domObj) {
    this._itemProgresses[itemId] = domObj;
    if (this._itemProgressCells[itemId]) { // Insert domObj if shown
      aas.util.Util.clearElement(this._itemProgressCells[itemId]);
      this._itemProgressCells[itemId].appendChild(this._itemProgresses[itemId]);
    }
  },

  /** Removes the action progress indicator for an item.
   * @param itemId A store-defined identifier for an item.
   */
  _removeProgressCell : function (itemId) {
    if (this._itemProgresses[itemId]) {
      if (this._itemProgressCells[itemId]) { // Remove domObj if shown
        var self = this;
        dojo.fadeOut({
          node: this._itemProgressCells[itemId],
          duration: 1000,
          onEnd: function() {
            aas.util.Util.clearElement(self._itemProgressCells[itemId]);
          }}).play();
      }
      delete this._itemProgresses[itemId];
    }
  },

  /** Update which buttons are enabled based on progress and callbacks.
   *
   */
  _updateButtonsEnabled : function() {
    var selected = {};
    for (var itemId in this._selectButtons) {
      var select = this._selectButtons[itemId];
      if (select.checked) {
        selected[itemId] = select.actionItem;
      }
    }
    for (var a in this._actions) {
      var action = this._actions[a];
      var button = this._actionButtons[action.title];
      // Enabled/disable based on callback, if such exists.
      if (action.enable) {
        button.disabled = !(action.enable(selected));
      } else {
        button.disabled = false;
      }
    }
  },

  /** Toggle the state of the select button for an item.
   *
   * @param item An item. If the item is not shown, the call does nothing.
   * @param value If a boolean, sets the select to that values, otherwise the
   * select is inverted.
   * @return The state that the select was changed to if it was changed,
   * null if it wasn't changed, and undefined if the item is not shown.
   */
  toggleSelect : function(item, value) {
    var itemId = this._getItemId(item);
    var select = this._selectButtons[itemId];
    if (select) {
      var toValue = value;
      if (typeof(value) != 'boolean') {
        toValue = !select.checked;
      }
      if (select.checked != toValue) {
        select.click();
        return toValue;
      } else {
        return null;
      }
    } else {
      return undefined;
    }
  },

  /** Toggle all select buttons and set the "select all"/"select none" link
   * to indicate doing the opposite toggle.
   * @param If given, indicates whether the buttons should be selected or not.
   * A true value means the buttons will end up selected.
   * Otherwise, an internal variable tracks whether to select on or off.
   */
  _toggleAllSelects : function(self, force) {
    if (typeof(force) == "boolean") {
      self._toggleAllState = force;
    } else {
      self._toggleAllState = !self._toggleAllState;
    }
    self._makeToggleAllLink();
    for (var select in self._selectButtons) {
      if (self._selectButtons[select].checked != self._toggleAllState) {
        self._selectButtons[select].click();
      }
    }
    self._updateButtonsEnabled();
  },

  _makeToggleAllLink : function() {
    if (this._toggleAllLink) {
      aas.util.Util.clearElement(this._toggleAllLink);
    }
    if (this._hasColumnActions()) {
      if (this._toggleAllState) {
        this._toggleAllLink.appendChild(document.createTextNode(lang.table.selectNone));
      } else {
        this._toggleAllLink.appendChild(document.createTextNode(lang.table.selectAll));
      }
    }
  },

  /**
   * Create the pager buttons for a multi-page table. This should only be
   * called from within show().
   */
  _createPager : function() {
    var index = this._currentIndex;
    var pageSize = this._currentItemsPerPage;
    var pageIndex = Math.floor(this._currentIndex / pageSize);

    var pagerElement = this.aasTablePageIndex;
    aas.util.Util.clearElement(pagerElement);
    var size = this._getSize();
    var self = this;

    // Items per page dropdown
    if (this._possiblePageSizes && this._possiblePageSizes.length > 1) {
      var label = document.createTextNode(lang.table.itemsPerPage);
      pagerElement.appendChild(label);

      var pageSizeChooser = document.createElement("select");
      var sortedSizes = [];
      dojo.forEach(this._possiblePageSizes, function(s) { sortedSizes.push(s); });
      sortedSizes.sort(function(a,b) { return a - b; });
      pageSizeChooser.onchange = function(event) {
        self.setItemsPerPage(parseInt(pageSizeChooser.options[pageSizeChooser.selectedIndex].value));
        self._reloadStorePage();
      };
      dojo.forEach(sortedSizes, function(size) {
        var choice = document.createElement("option");
        choice.value = size;
        choice.appendChild(document.createTextNode(size));
        pageSizeChooser.appendChild(choice);
      });
      for (var i = 0; i < sortedSizes.length; i++) {
        if (sortedSizes[i] == self._currentItemsPerPage) {
          pageSizeChooser.options[i].selected = true;
          pageSizeChooser.selectedIndex = i;
        } else {
          pageSizeChooser.options[i].selected = false;
        }
      }
      pagerElement.appendChild(pageSizeChooser);
    }

    /**
     * Creates HTML for a part of the pager (prev, next or page number).
     *
     * @param title
     *            Some fully escaped HTML that should be shown.
     * @param relativePageIndex
     *            The page index relative to the current page that the added
     *            link should lead to.
     * @param displayCond
     *            if true, the title parameter should have a link to another
     *            page on it, otherwise is should just be text.
     * @return HTML displaying the title with or without a link.
     */
    var createPageLink = function(title, relativePageIndex, displayCond) {
      var elm = null;
      if (displayCond) {
        var startIndex = index + (pageSize * relativePageIndex);
        elm = document.createElement("a");
        elm.href = "javascript:void(0)";
        elm.onclick = function(event) {
          self._currentIndex = startIndex;
          self._toggleAllSelects(self, false);
          self._reloadStorePage();
        };
      } else {
        elm = document.createElement("span");
      }
      elm.innerHTML = title;
      return elm;
    };

    var firstElement;
    var prevElement;
    var nextElement;
    var lastElement;

    // "First" link
    firstElement = createPageLink("|&lt;  ", - pageIndex, (pageIndex > 0));
    pagerElement.appendChild(firstElement);

    // "Previous" link
    prevElement = createPageLink("&lt; ", -1, (pageIndex > 0));
    pagerElement.appendChild(prevElement);

    var numberOfPages = Math.ceil(size / pageSize);
    var pageLinksStartIndex = Math.max((pageIndex - 5), 0);
    var pageLinksEndIndex = Math.min(numberOfPages,
         Math.min(10, numberOfPages) + pageLinksStartIndex);
    pageLinksStartIndex = Math.max(pageLinksEndIndex - 10, 0);
    // Re-adjust start index if we at the end
    for (var i = pageLinksStartIndex; i < pageLinksEndIndex; i++) {
      var elm = createPageLink((i + 1) + " ", (i - pageIndex),
          (i != pageIndex));
      pagerElement.appendChild(elm);
    }
    // "Next" link
    nextElement = createPageLink(" &gt; ", 1,
        ((pageIndex + 1) * pageSize < size));
    pagerElement.appendChild(nextElement);

    // "Last" link
    lastElement = createPageLink(" &gt;| ", numberOfPages - pageIndex - 1,
        ((pageIndex + 1) * pageSize < size));
    pagerElement.appendChild(lastElement);
  },

  /** Load and show the current page.  For noncomplete stores, this calls the
   * provided loadStorePage function to load the required elements.
   */
  _reloadStorePage: function() {
    if (this._loadStorePage) {
      this._showAlert(lang.table.loading);
       this._loadStorePage(this._currentIndex, this._currentItemsPerPage);
    } else {
       this.show(this._currentIndex, null, this._currentRequest);
    }
  },

  /** Set how many items will be shown on a page in future show() calls.
   * @param items Number of items to show.  Must be one of the values
   *        passed as the initial pageSize parameters.
   */
  setItemsPerPage : function(/* int */ items) {
     this._currentItemsPerPage = items;
     this._persist();
     // Make sure the index is at the start of a new-size page
     this._currentIndex -= (this._currentIndex % this._currentItemsPerPage);
  },

  /** Get the current number of items per page. Some queries need to know this
   * number to work.
   */
  getItemsPerPage : function() {
    return this._currentItemsPerPage;
  },

  /** Clears all rows from the table. */
  clearTable : function() {
    var children = this.aasTableBody.childNodes;
    while (children.length > 0) {
      this.aasTableBody.removeChild(children[0]);
    }
    
  },

  /**
   * Sets the store object and refreshes the view.
   *
   * @param store
   *            A store object to draw data from.
   * @param isComplete (optional)
   *            If given, is true if this store has all its data internally.
   *            Otherwise, the loadStorePage argument must be given at
   *            some point before use.
   * @param loadStorePage (optional)
   *            If given, sets the function that will be used to force the
   *            store to read pages.  Must be given prior to displaying
   *            the table if the store is not complete.  Parameters:
   *            <ul>
   *            <li> startIndex: Index into the store to start at.
   *            </ul>
   */
  setStore : function(/* dojo.data */store, /* boolean? */isComplete,
                      /* function? */loadStorePage) {
    this.store = store;
    if (isComplete !== undefined) {
      this.isStoreComplete = isComplete;
    }
    if (loadStorePage !== undefined) {
      this._loadStorePage = loadStorePage;
    }
    if (this._currentIndex !== undefined) {
      this.refresh();
    }
  },

  /** Refreshes the view by calling show(). */
  refresh : function() {
    this.show(this._currentIndex, null,	this._currentRequest);
  },

  /**
   * Create the table header row. This should only be called from within the
   * constructor. It initializes various elements that are used in show().
   */
  _createHeader : function() {
    var header = this._header;
    var self = this;
    if (this._filter) {
      // Filters row
      var row = document.createElement("tr");
      // Use select column + progress column to show 'filter:'
      var cell = document.createElement("td");
      cell.colSpan = "2";
      cell.align = "right";
      cell.appendChild(document.createTextNode(lang.table.filter));
      row.appendChild(cell);
      //      var inputFields = [];
      /** Create a filter element for a column
       * @param h The header entry from the list given to the constructor
       */
      dojo.forEach(header, function(h) {
        var column = h[self._contentIdentifierAttr];
        var th = document.createElement("th");
        if (h.hasFilter !== false) {
          var input = document.createElement("input");
          input.id = "input" + column;
          if (self._filters[column]) {
            input.value = self._filters[column];
            if (input.value) {
              dojo.addClass(input, "hasContents");
            }
          }
          var setFilterBoxSize = function() {
            var minWidth=4;
            if (input.value) {
              input.size = Math.max(minWidth, Math.min(10, input.value.length));
            } else {
              input.size = minWidth;
            }
          };
          setFilterBoxSize();
          th.appendChild(input);

          var updateFilters = function(event) {
            var changed = false;
            var trimmedValue = trim(input.value);
            if (input.value != trimmedValue) {
              input.value = trimmedValue;
            }
            if (self._filters[column] != trimmedValue) {
              changed = true;
            }
            if (trimmedValue.length == 0) {
              dojo.removeClass(input, "hasContents");
              delete(self._filters[column]);
            } else {
              dojo.addClass(input, "hasContents");
              self._filters[column] = trimmedValue;
            }
            setFilterBoxSize();
            if (changed) {
              var starredFilters = self._starifyFilters(self._filters);
              self._currentRequest = self._filter(self._currentRequest, starredFilters);

              //Start at index 0 when filter has changed
              self._currentIndex = 0;

              self._persist();
              self._reloadStorePage();
            }
          };
          input.onblur = updateFilters;
          input.onkeypress = function(e) {
            var event = dojo.fixEvent(e, input);
            if (event.keyCode == 13) {
              input.blur();
              return false;
            } else {
              setFilterBoxSize();
              return true;
            }
          };
          //        inputFields.push(input);
        } else {
          th.innerHTML = "&nbsp;";
        }
        row.appendChild(th);
        h[self._filterAttr] = null;
      });
      /*
      var toolTipText = document.createElement("span");
      toolTipText.innerHTML = lang.table.filterTooltip;
      var toolTip = new dijit.Tooltip( { connectId: inputFields, showDelay: 2000}, toolTipText);
      toolTip.startup();
      */
      this.aasTableHeader.appendChild(row);
    }
    // Titles row
    var row = document.createElement("tr");
    if (this._hasColumnActions()) {
      var selCol = document.createElement("th");
      selCol.align= "center";
      // Make "toggle all" selector
      var selLink = document.createElement("a");
      selLink.href = "#";
      selLink.onclick = function() { self._toggleAllSelects(self); };
      this._toggleAllLink = selLink;
      selCol.appendChild(selLink);
      row.appendChild(selCol); // Select column
    } else {
      row.appendChild(document.createElement("th")); // Select column
    }
    row.appendChild(document.createElement("th")); // Progress column
    /**
     * Create a header element for a column.
     *
     * @param h
     *            The header entry from the list given to the constructor
     */
    dojo.forEach(header, function(h) {
      var column = h[self._contentIdentifierAttr];

      if (h.valueHandler) {
        self._valueHandlers[column] = h.valueHandler;
      }
      var th = self._createTitleElement(h);
      self._identifiers.push(column);
      self._headerMap[column] = h;
      row.appendChild(th);
    });
    this.aasTableHeader.appendChild(row);
    this._showAlert(lang.table.loading);
    if (this._filterChoices && this._filterChoices != "fetching") {
      //window.setTimeout(function() { self._updateFilterChoices(); }, 0);
    }
  },

  _updateFilterChoices: function() {
    for (var column in this._filterChoices) {
      var choices = this._filterChoices[column];
      var input = dojo.byId("input" + column);
      this._makeFilterBox(choices, input);
    }
  },

  _makeFilterBox: function(choices, input) {
    if (input == null) {
      return;
    }
    var options = new dojo.data.ItemFileWriteStore({data: {identifier: 'name', items:[]}});
    for (var c in choices) {
      options.newItem({name: choices[c]});
    }
    var combobox = new dijit.form.ComboBox({store: options, hasDownArrow: true, onChange: function(selected) {
      input.focus();
      input.value = selected;
      input.blur();
    }}, input);
    combobox.onblur = input.onblur;
    combobox.onkeypress = input.onkeypress;
  },

  /** Turn a list of externally represented filters into internal wildcard filters
   *
   * @param filterList List of strings, optionally with * or ? or surrounded by ""
   * @return starredFilters List of the same strings, those with no special markup
   * surrounded by **, those with "" stripped to the bare string, those starting
   * with >, = or < left alone.
   */
  _starifyFilters : function(filterList) {
    var starredFilters = {};
    for (var f in filterList) {
      var filter = filterList[f];
      if (filter.indexOf("*") > -1 || filter.indexOf("?") > -1
       || filter.charAt(0) == '=' || filter.charAt(0) == '<' || filter.charAt(0) == '>') {
        starredFilters[f] = filter;
      } else if (filter.charAt(0) == "\"" && filter.charAt(filter.length - 1) == "\"") {
        starredFilters[f] = filter.substring(1, filter.length - 1);
      } else {
        starredFilters[f] = "*" + filter + "*";
      }
    }
    return starredFilters;
  },

  /** Create the DOM element for a column title.
   * @param h A hash of values for a header, as given to the constructor.
   * @returns A DOM element
   */
  _createTitleElement : function( /* header hash */ h ) {
    var th = document.createElement("th");
    if (h.isSortable) {
      var columnName = h[this._contentIdentifierAttr];
      this._sortHeaders[columnName] = 0; // 0=ascending,
      // 1=descending
      var sortColumn = h.sortColumn ? h.sortColumn : h.name;

      var sortIcon = document.createElement("span");
      sortIcon.innerHTML = "&nbsp;&nbsp;";
      this._headerSortIcons.push(sortIcon);

      var sortLink = document.createElement("a");
      sortLink.href = "javascript:void(0)";
      sortLink.innerHTML = h[this._headerTitleAttr];
      var self = this;
      sortLink.onclick = function(event) {
        self._sortByColumn(sortColumn, sortIcon);

        if (self.isStoreComplete) {
          //self.setStore(self.store);
          self.refresh();
        } else {
          // Fetch new data
          if (self._reloadStore) {
            self._currentIndex = 0;
            self._reloadStore(self.sort);
            self.refresh();
          } else {
            throw new Error("Incomplete Table needs a reloadStore function");
          }
        }
      };
      th.appendChild(sortLink);
      th.appendChild(sortIcon);
      for (var sortIndex in this.sort) {
        if (this.sort[sortIndex] && this.sort[sortIndex].attribute == columnName){
          // This translates the column name given in the constructor to
          // the sort-by column.
          sortIcon.className = this._sortIconClasses[(this.sort[sortIndex].descending) ? 1 : 0];
          break;
        }
      }
    } else {
      th.innerHTML = h[this._headerTitleAttr];
    }
    return th;
  },

  /** Set up the internal structures for sorting by a column. This function
   * does not actually refresh the data, but the next refresh will use the given
   * sort.
   * @param sortColumn Column to sort on
   * @param sortIcon DOM node for the sort arrow
   * @param forcedOrder If given, a boolean that indicates if the sort should
   *  be descending. If not given, the sort order will be the opposite of before,
   *  initially ascending.
   */
  _sortByColumn: function(sortColumn, sortIcon, forcedOrder) {
    var self = this;
    if (self._sortMap[sortColumn] === undefined) {
      var descending = 0;
    } else {
      var descending = !self._sortMap[sortColumn];
    }
    if (forcedOrder !== undefined) {
      descending = forcedOrder;
    }

    // Special care is needed if the table is multisortable
    if (self._isMultiSortable) {
      for (var i = 0; i < self.sort.length; i++) {
        if (self.sort[i] && self.sort[i].attribute == sortColumn) {
          // If the attribute already exist in the current
          // sorting, remove it
          self.sort.splice(i, 1);
        }
      }
      self.sort.unshift({
        attribute : sortColumn,
        descending : descending
      });
    } else {
      self.sort = []; // We only handle a single
      self.sort.push({
        attribute : sortColumn,
        descending : descending
      });
      for (var i in self._headerSortIcons) {
        if (self._headerSortIcons[i]) {
          self._headerSortIcons[i].className = "";
        }
      }
    }
    sortIcon.className = self._sortIconClasses[(descending) ? 1 : 0];

    self._currentRequest.sort = self.sort;
    self._sortMap[sortColumn] = descending;
  },

  _showAlert : function( /* string */ text) {
    if (text) {
      this._loadingDiv = this._showAlertDiv(true, this._loadingDiv, text);
    } else {
      this._loadingDiv = this._showAlertDiv(false, this._loadingDiv, text);
    }
  },

  /** Show a generic label instead of items, when the items cannot be displayed
   * (e.g. while loading or when there are no items).
   * @param show Whether or not the item will be visible in the DOM.
   * @param An element previously created by a call to this function, or
   *   undefined/null.
   * @param The text to show in the label (will be passed to createTextNode).
   * @returns The table element that displays the label.  This should be
   *   stored for future calls.  This allows multiple tables in a page without
   *   ids interfering.
   */
   _showAlertDiv : function( /* boolean */ show, /* dom element */ td,
                            /* string */ text ) {
    if (!td) {
      var tr = document.createElement("tr");
      td = document.createElement("td");
      td.appendChild(document.createTextNode(text));
      td.colSpan = 2 + this._header.length;
      dojo.addClass(td, "msgLogCent");
      tr.appendChild(td);
      this.aasTableHeader.appendChild(tr);
    } else {
      td.removeChild(td.childNodes[0]
        );
      td.appendChild(document.createTextNode(text));
    }
    if (show) {
      td.style.display = '';
      td.style.visibility = 'visible';
    } else {
      td.style.display = 'none';
      td.style.visibility = 'hidden';
    }
    return td;
  }
});

}
