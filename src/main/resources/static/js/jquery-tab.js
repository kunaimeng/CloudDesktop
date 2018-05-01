;(function (defaults, $, window, document, undefined) {
    'use strict';
    $.extend({
        tabifySetup: function (options) {
            return $.extend(defaults, options);
        }
    }).fn.extend({
        tabify: function (options) {
            options = $.extend({}, defaults, options);
            return $(this).each(function () {
                var $element, tabHTML, $tabs, $sections;
                $element = $(this);
                $sections = $element.children();
                tabHTML = '<ul class="tab-nav">';
                $sections.each(function () {
                    if ($(this).attr("title") && $(this).attr("id")) {
                        tabHTML += '<li><a href="#' + $(this).attr("id") + '">' + $(this).attr("title") + '<i class="fa fa-times"></i></a></li>';
                    }
                });
                tabHTML += '</ul>';
                $element.prepend(tabHTML);
                $tabs = $element.find('.tab-nav li');
                var activateTab = function (id) {
                    $tabs.filter('.active').removeClass('active');
                    $sections.filter('.active').removeClass('active');
                    $tabs.has('a[href="' + id + '"]').addClass('active');
                    $sections.filter(id).addClass('active');
                };
                $tabs.on('click', function (e) {
                    activateTab($(this).find('a').attr('href'));
                    e.preventDefault();
                });
                activateTab($tabs.first().find('a').attr('href'));
            });
        }
    });
})({
    property: "value",
    otherProperty: "value"
}, jQuery, window, document);