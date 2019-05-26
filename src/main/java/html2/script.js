$(document).ready(function(){

var elements = {

    aboutUs: $("#about-link"),
    content: $("#content"),
    stuff: $("#product-link"),
    index: $("#index-link"),
};
var loadaboutUs = function(){
elements.content.load("fragment/aboutUs.html");
};
var loadStuff = function(){
    elements.content.load("fragment/stuff.html");
}
    var products = {
        bookTitles: $("#bookTitles"),
        books: $("#books"),
        pens: $("#pens"),
        penstitle: $("#pensTitle")
    }
var loadProduct = function(){
    elements.content.load("fragment/indexfragment.html")      
products.bookTitles.hide();
products.penstitle.hide();
products.bookTitles.click(toogleBookVisibility);
products.bookTitles.click(showPens);
    }
    var toogleBookVisibility = function () {
        if (products.bookTitles.is(":visible")) {
            products.bookTitles.hide();
        }
        else { products.bookTitles.show(); }
    }
    var tooglePenVisibility = function () {
        if (products.penstitle.is(":visible")) {
            products.penstitle.hide();
        }
        else { products.penstitle.show(); }
    }
var loadIndex = function(){
    elements.content.load("fragment/indexFragment.html");

}
var showBooks = function(){
    products.bookTitles.show();
}
var showPens = function(){
    products.penstitle.show();
}
elements.aboutUs.click(loadaboutUs);
elements.stuff.click(loadStuff);
elements.index.click(loadIndex);

});

