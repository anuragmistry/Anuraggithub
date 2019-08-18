package com.onmobile.xpaths;

import org.openqa.selenium.By;

public interface PortalXpath {
	//Menu in Home Page
	By MenuImg 	       =By.xpath("//*[@id='header-container']/descendant::img[@id='menuImg']");
	By MenuOption      =By.xpath("//*[@id='menu-div']/descendant::a");
	By MenuOptionText  =By.xpath("//*[@id='menu-div']/descendant::a[contains(text(),'replaceMe')]");
	//Portal Logo
	By PortalLogoImg 	 =By.xpath("//*[@id='header-container']/descendant::*[contains(@class,'logo align-centre')]/descendant::img");
	By PortalLogoLink    =By.xpath("//*[@id='header-container']/descendant::*[contains(@class,'logo align-centre')]/descendant::a");
	By LogoBanner 	     =By.xpath("//*[@class='banner-header']/descendant::img[contains(@class,'banner')]");
	//Search icon
	By SearchImg       =By.xpath("//*[@id='search']/descendant::img");
	By SearchInputBox  =By.xpath("//*[@id='searchKey' and @name='st']");
	By SearchButton    =By.xpath("//*[@class='btn btn-search' and @type='submit']");
	By Searchtitle     =By.xpath("//*[@class='search-title']/descendant::b");
	By NoResults       =By.xpath("//*[@class='noresults']");
	//Continent Map Image
	By MapImage        =By.xpath("//a/child::img[contains(@class,'banner')]");
	//wordCloud link
	By Modulewordcloud   =By.xpath("//*[@class='module module-wordcloud']");
	By wordcloudlink     =By.xpath("//li[contains(@class,'wordcloud-link')]/descendant::a");
	
	By BannerImage          =By.xpath("//*[@class='module module-banner']/descendant::img");
	By ClickOnNthBanner     =By.xpath("(//*[@class='module module-banner']/descendant::img)['replaceMe']");
    //Footer section
	By FooterSection    =By.xpath("//*[@class='footer']");
	By FooterTextlink   =By.xpath("//*[@class='footer']/descendant::a");
	By Footerlink		=By.xpath("//*[@class='footer']/descendant::a[contains(text(),'replaceMe')]");
	By FooterMiddlelink =By.xpath("//*[@class='footer']/descendant::tr[@class='middle']/descendant::a");
	//Carousal module
	By SwipeModule           =By.xpath("//*[contains(@class,'carousel module-swipe')]");
	By ListOfImage           =By.xpath("//*[contains(@class,'carousel module-swipe')]/descendant::li");
	By CarouselImgLink       =By.xpath("//*[contains(@class,'carousel')]/descendant::li[contains(@style,'0px')]/descendant::a[1]");
	By TopCarouselImgTitle   =By.xpath("//*[contains(@class,'carousel')]/descendant::li[contains(@style,'0px')]/descendant::*[@class='title']/descendant::a");
	By TopCarouselImg        =By.xpath("//*[contains(@class,'carousel')]/descendant::li[contains(@style,'0px')]/descendant::img[@class='thumbnail']");
	By CarouselImg           =By.xpath("//*[contains(@class,'carousel module-swipe')]/descendant::img[@class='thumbnail']");
	By CarouselTitle         =By.xpath("//*[contains(@class,'carousel module-swipe')]/descendant::*[@class='title']/descendant::a");
	By CarouselRatingImage   =By.xpath("//*[contains(@class,'carousel module-swipe')]/descendant::*[@class='info']/descendant::img[contains(@class,'rating-stars')]");
	By ThumbnailImg          =By.xpath("//*[contains(@class,'carousel')]/descendant::img[@class='thumbnail']");
	//Category Page
	By PortalTitle     =By.tagName("title");
	By HomePageLink    =By.xpath("//a[contains(@class,'previous') and text()='Home']");
	By CurrentPageLink =By.xpath("//a[contains(@class,'current')]");
	By PreviousPageLink=By.xpath("//a[contains(@class,'previous')]");
	By SubPageLink     =By.xpath("//a[contains(@class,'subpage')]");
	By ControlerHome   =By.xpath("//*[contains(@class,'previous') and text()='Home']/following::a[text()='replaceMe']");
	By ModuleTitle     =By.xpath("//*[@class='module-title']");
	By ValidateTitle   =By.xpath("//*[@class='module-title'and text()='replaceMe']");
	By CarouselImage   =By.xpath("//*[contains(@class,'carousel')]/descendant::img[@class='thumbnail']");
	By ThumbnailImage  =By.xpath("//*[@class='module-title' and text()='replaceMe']/ancestor::*/*[contains(@class,'carousel')]/descendant::img[@class='thumbnail']");
	By FristThumbnailImage  =By.xpath("//*[@class='module-title' and text()='replaceMe']/ancestor::*/*[contains(@class,'carousel')]/descendant::img[@class='thumbnail'][1]");
	By ThumbnailImgTitle  =By.xpath("//*[@class='module-title' and text()='replaceMe']/ancestor::*/*[contains(@class,'carousel')]/descendant::*[@class='title']/descendant::a");
	By MoreButton      =By.xpath("//*[@class='module-title' and text()='replaceMe']/ancestor::tr/descendant::*[contains(@class,'btn-more')]");
	By BennerImg       =By.xpath("//a/child::*[contains(@class,'banner')]");
	By MoreBtnCategoryName =By.xpath("//*[@class='module-title' and text()='replaceMe']/ancestor::tr/descendant::a[@class='btn btn-more']");
	By CategoryTitleName   =By.xpath("//*[@class='module-title' and text()='replaceMe']");
	
	//Module carousel NoPadding
	By ModuleBody                  =By.xpath("//*[@class='module-body']");
	By ModuleImgBanner             =By.xpath("//*[@class='module-body']/descendant::a/img[@class='banner']");
	By Modulecarouselnopadding     =By.xpath("//*[@class='module-carousel-no-padding']");
	By ModulecarouselnopaddingImage=By.xpath("(//*[@class='module-carousel-no-padding'])[replaceMe]/descendant::a/img[@class='banner']");
	//Subscription Page
	By UNSubsPriceText      =By.xpath("//*[contains(@class,'unsubscribed-price')]");
	By SubcribedPricetext   =By.xpath("//p[@class='subscribed']");
	By PreviewImage         =By.xpath("//*[@class='preview']/descendant::img[@class='preview-image']");
	By SubscribedPreviewImage=By.xpath("//*[@class='subscribed']/descendant::img[@class='preview-image']");
	By PreviewImageTtile    =By.xpath("//*[@class='preview']/descendant::*[@class='title']");
	By PreviewImageRating   =By.xpath("//*[@class='preview']/descendant::*[@class='rating']/descendant::img");
	By SubsPriceText        =By.xpath("//*[@class='subscribe-price']");
	By ActiveButton         =By.xpath("//*[@class='buy']/descendant::a[contains(@class,'buy')]");
	By CancelButton         =By.xpath("(//*[@class='buy']/descendant::a[contains(@class,'cancel')])[1]");
	By BuyButton            =By.xpath("//*[@class='buy']/descendant::a[text()='COMPRAR']");
	By PPUpriceInfo         =By.xpath("//*[@class='price-info']/p");
	
	By PreviewThumbnailImage         =By.xpath("//*[@class='preview']/descendant::img[@class='thumbnail']");
	By PreviewThumbnailtitle        =By.xpath("//*[@class='info']/descendant::td[@class='tile']");
	By PreviewThumbnailDescrip        =By.xpath("//*[@class='info']/descendant::td[@class='genre']");
	//confirmation Page
	By SubscribedImage         =By.xpath("//*[@class='thumbnail']");
	By Points                  =By.xpath("//*[@class='points']");
	By PointsText              =By.xpath("//*[@class='points']/descendant::p");
	By PointsImage             =By.xpath("//*[@class='points']/descendant::img");
	By Subscribedtext          =By.xpath("//*[@class='sub-text']");
	By SubscribedMsg           =By.xpath("//*[@class='subscribed']/descendant::b");
	By SubscribedTickImg       =By.xpath("//*[@class='subscribed']/descendant::img[contains(@src,'SubscribedTick')]");
	By CaptionText             =By.xpath("//*[@class='caption']/descendant::p");
	By CaptionLink             =By.xpath("//*[@class='caption']/descendant::p/descendant::a");
	By CaptionsConditionLink   =By.xpath("//*[@class='points']/descendant::*[@class='caption']/descendant::a");
	By SubscribeImageTitle     =By.xpath("//*[@class='subscribed']/descendant::td[@class='tile']");
	By SubscribedThumbnail     =By.xpath("//*[@class='subscribed']/descendant::img[@class='thumbnail']");
	
	By TermsConditionText      =By.xpath("//*[@class='subscribe-smallprint']");
	By TermsConditionLink      =By.xpath("//*[@class='subscribe-smallprint']/descendant::a");
	By ContinueButton          =By.xpath("//*[@class='button']/descendant::a[contains(@class,'continue')]");
	By ConditionLink           =By.xpath("//*[@class='caption']/descendant::a");
	//Download Page
	By DownloadThumbnail     =By.xpath("//*[@class='download']/descendant::img[@class='thumbnail']");
	By DownloadImageTitle     =By.xpath("//*[@class='download']/descendant::td[@class='tile']");
	//Gallery Page
	By ThumbnailGallery        =By.xpath("//*[@class='gallery-body']/descendant::img[@class='thumbnail']");
	By ClickOnNthThumbnail     =By.xpath("(//*[@class='gallery-body']/descendant::img[@class='thumbnail'])['replaceMe']");
	By GalleryMoreButton       =By.xpath("//a[contains(@class,'more')]");
	By GalleryTitle            =By.xpath("//*[contains(@class,'gallery-title')]");
	By GalleryContinueButton   =By.xpath("//a[contains(@class,'continue')]");
	By ThumbnailGalleryTitle   =By.xpath("//*[contains(@class,'gallery')]/descendant::tr[@class='title']/descendant::a");
	By ThumbnailRatingStar     =By.xpath("//*[contains(@class,'gallery')]/descendant::img[contains(@class,'rating-stars')]");
	By PreviewGalleryTitle     =By.xpath("//*[@class='preview']/descendant::td[@class='title']");
	By GalleryBanner           =By.xpath("//*[@class='gallery-banner']");
	By GalleryDescription      =By.xpath("//*[@class='gallery-description']");
	
	By BackArrow=By.xpath("//*[@class='back-arrow']/following::*/descendant::*[contains(text(),'< Atrás')]");
	
	
	By ErrorPage      =By.xpath("//*[@class='error']");
	By Errortitle     =By.xpath("//*[@class='error-title']");
	By ErrorText      =By.xpath("//*[@class='error']/descendant::p");
	By Errorclosebtn  =By.xpath("//*[contains(@class,'btn-close-error')]");
	
	//Watch Video Page
	By PreviousPageTitle      =By.xpath("//a[@class='breadcrumbs-previous']");
	By CurrentPageTitle       =By.xpath("//a[@class='breadcrumbs-current']");
	By Playercontainer        =By.xpath("//*[@class='player-container']");
	By PlayVideoButton        =By.xpath("//button[@title='Play Video']");
	By VideoDisplayTime       =By.xpath("//*[@class='vjs-duration-display']");
	By CurrentVideoTime       =By.xpath("//*[@class='vjs-current-time-display']");
	By PrograssBar            =By.xpath("//*[contains(@aria-label,'Progress Bar')]");
	By PlayBtn                =By.xpath("//button[@title='Play']");
    By PauseBtn               =By.xpath("//button[@title='Pause']");
	By MuteBtn                =By.xpath("//button[@title='Mute']");
	By UnMuteBtn              =By.xpath("//button[@title='Unmute']");
	By FullScreenBtn          =By.xpath("//button[@title='Fullscreen']");
	By NONFullScreenBtn       =By.xpath("//button[@title='Non-Fullscreen']");
	By VideoTitle             =By.xpath("//*[@class='player-container']/descendant::tr[@class='title']/td");
	By VideoRatingImg         =By.xpath("//*[@class='player-container']/descendant::tr[@class='info']/descendant::img");
	By DescriptionTitle       =By.xpath("//*[@class='description-title']");
	By DescriptionText       =By.xpath("//*[@class='description']/descendant::p");
	By SimilarTitle           =By.xpath("//*[@class='similar-title']");
	
	By RatingInfoImg          =By.xpath("//*[@class='ratings-info']/descendant::img");
	By RatingInfo             =By.xpath("//*[@class='ratings-info']/descendant::p");
	By UnRateImg              =By.xpath("//*[@class='rating-star']");
	By RateContent            =By.xpath("//*[@class='rate-content']");
	By RatingStarImg          =By.xpath("//*[@class='rate-content']/descendant::img[@class='rating-star']");
	By Ratebuttonsubmit       =By.xpath("//a[@id='ratebuttonsubmit']");
	//favourites
	By NoFavrtItemText        =By.xpath("//*[@class='my-downloads']/descendant::p");
	By FavouriteTitle         =By.xpath("//*[@class='favourite-title']");
	By FavouritePostmessage   =By.xpath("//*[@id='favourite-post-message']");
	By FavouritePremessage    =By.xpath("//*[@id='favourite-pre-message']");
	By FavouriteBtnText       =By.xpath("//*[contains(@class,'btn-favourite')]/descendant::*[text()='Favoritos']");
	By FavouriteBtnImg        =By.xpath("//*[contains(@class,'btn-favourite')]/descendant::img");				
	By FavouriteBtnDisabled   =By.xpath("//*[contains(@class,'locker-favourite disabled')]");
	
	By Favouritelockertitle   =By.xpath("//*[contains(@class,'locker-title')]");	
	By Favouritethumbnail     =By.xpath("//*[@id='content-video']/descendant::img[@class='thumbnail']");
	By Favouritelockercaption =By.xpath("//*[@class='locker-caption']");
	By RedownloadBtn          =By.xpath("//*[@class='redownload']/descendant::img");
	By RedownloadLink         =By.xpath("//*[@class='redownload']/descendant::a");
	By DeleteBtn              =By.xpath("//*[@class='delete']/descendant::img");
	By DeleteLink             =By.xpath("//*[@class='delete']/descendant::a");
	
	By Favourite_Img_Title    =By.xpath("//*[@class='locker-caption' and contains(text(),'replaceMe')]");
	By Favourite_thumbnail    =By.xpath("//*[@class='locker-caption' and contains(text(),'replaceMe')]/ancestor::*//*[@id='content-video']/descendant::img[@class='thumbnail']");
	By Favourite_redownload   =By.xpath("//*[@class='locker-caption' and contains(text(),'replaceMe')]/ancestor::*//*[@class='redownload']/descendant::img");
	By Favourite_Delete       =By.xpath("//*[@class='locker-caption' and contains(text(),'replaceMe')]/ancestor::*//*[@class='delete']/descendant::img");
	
	By CookiesText           =By.xpath("//*[@class='om-noticetext']");
	By CookiesHereLink       =By.xpath("//*[@class='om-noticetext']/a");
	By CookiesSection        =By.xpath("//*[@class='terms-conditions']");
	By CookiesHeaderTitle    =By.xpath("//*[@class='terms-conditions']/descendant::*[@class='static-title']");
	
	//Download Page//download-preview
	By DownLoadButton            =By.xpath("//*[contains(@class,'btn-download')]");
	By DownLoadThumbnail         =By.xpath("//*[@class='download']/descendant::img[@class='thumbnail']");
	By DownLoadThumbnailTitle    =By.xpath("//*[@class='info']/descendant::*[@class='tile']");
	By DownLoadThumbnailRatingImg=By.xpath("//*[@class='download']/descendant::*[@class='rating']/descendant::img");
	By DownLoadsubscribeMsg      =By.xpath("//*[@class='download']/descendant::*[@class='subscribe-message']");
	By DownLoadpurchaseMsg       =By.xpath("//*[@class='download']/descendant::*[@class='purchase-message']");
	By DownLoadDescriptionText   =By.xpath("//*[@id='description-text']");
	By DownLoadCreditMsgText     =By.xpath("//p[@class='subscription']");
	By DownLoadScreenShotSection =By.xpath("//*[@id='screenshots-touch']");
	By DownLoadScreenshotImg     =By.xpath("//*[@id='screenshots-touch']/descendant::img");
	
	By DownLoadDescripTitle          =By.xpath("//*[@class='description-title']");
	By DownLoaddescriptionText       =By.xpath("//p[@class='description']");
	By DownLoadThumbnailratingtitle  =By.xpath("//*[@class='rating-title']");
	By DownLoadratingshistogram      =By.xpath("//*[@id='ratingshistogram']");
	
	By RecomendationHeader           =By.xpath("//*[@class='similar-title']");
	By RecomendationMoreBtn          =By.xpath("//*[@class='btn btn-more']");
	By RecomendationThumbnail        =By.xpath("//*[contains(@class,'module module-carousel')]/descendant::img[@class='thumbnail']");
	By RecomendationThumbnailTitle   =By.xpath("//*[contains(@class,'module module-carousel')]/descendant::*[@class='title']/descendant::a");
	
	
//Ugames
	By AlertContainer        =By.xpath("//*[@id='acc-alert-container']");
	By AlertContainerClose   =By.xpath("//a[@id='acc-alert-close']");
	By MenuIcon        =By.xpath("//*[@id='header']/descendant::img[@id='ic-menu']");
	By MenuList        =By.xpath("//*[@id='menu']/descendant::span");
	By MenuHeaderH1        =By.xpath("//*[@id='menu']/descendant::h1");
	By SelectMenu       =By.xpath("//*[@id='menu']/descendant::span[text()='replaceMe']");
	By Validate_Menu_Img=By.xpath("//*[text()='replaceMe']/preceding-sibling::img");
	By LogoTitle        =By.xpath("//*[@class='title' and text()='Movistar Juegos']");
	By LogoText        =By.xpath("//*[@id='header']/descendant::*[text()='Movistar Juegos']");
	By LogoLink        =By.xpath("//*[@id='header']/descendant::*[text()='Movistar Juegos']/parent::a");
	By SearchIcon      =By.xpath("//*[@id='search-card']/descendant::img[@id='ic-search']");
	By SearchBoxInsideText  =By.xpath("//*[@id='search-card']/descendant::td[text()='Buscar juegos']");
	By ICSearchInputBox  =By.xpath("//input[@id='search-term' and @name='q']");
	By IcSearchButton  =By.xpath("//img[@id='ic-search-search']");
	By SearchBackIcon  =By.xpath("//img[@id='ic-search-back']");
	By SearchFailedImg  =By.xpath("//*[@id='search-failed']/descendant::img");
	By SearchFailedText  =By.xpath("//*[@id='search-failed']/descendant::h1");
	By TryAnotherSearch  =By.xpath("//*[@id='search-failed']/descendant::h2");
	By CloseSearchIcon  =By.xpath("//*[@id='ic-search-close']");
	By SearchCaption  =By.xpath("//*[@class='module-contentListItem']/descendant::*[@class='caption']/span");
	By SearchImage    =By.xpath("//*[text()='replaceMe']/../../preceding-sibling::*/descendant::img");

	By ServicepromotionInbold    =By.xpath("//*[@id='service-promotion']/descendant::*[contains(@class,'bold')]");
	By ServicepromotionInItalic   =By.xpath("//*[@id='service-promotion']/descendant::span");
	By ServicepromotionPageLink   =By.xpath("//*[@id='service-promotion']/descendant::a");
	
	By ContentBanner     =By.xpath("//*[@class='content-banner']");
	By CategoriesName    =By.xpath("//*[@id='categories']/descendant::*[contains(@class,'category-filter')]");
	By ModuleContentItem        =By.xpath("//*[@class='module-contentItem']");
	By ModuleContentItemTexth1    =By.xpath("//*[@class='module-contentItem']/descendant::h1");
	By ModuleContentItemTexth2    =By.xpath("//*[@class='module-contentItem']/descendant::h2");
	By ModuleContentItemTexth3    =By.xpath("//*[@class='module-contentItem']/descendant::h3");
	By ModuleContentItemImg     =By.xpath("//*[@class='module-contentItem']/descendant::img");
//	By ItemdownloadImg          =By.xpath("//*[@class='button-download']/descendant::img");
	By ItemdownloadImg          =By.xpath("//*[contains(@class,'button-download')]");
	By ModuleheaderName         =By.xpath("//*[@class='module-header']/descendant::td[1]");
	By ValidateHeaderName       =By.xpath("//*[@class='module-header']/descendant::td[text()='replaceMe']");
	By ValidateHeaderMoreBtn    =By.xpath("//*[@class='module-header']/descendant::td[text()='replaceMe']/../descendant::a[text()='Ver más']");
	//By ModulecarouselImg        =By.xpath("//*[@class='module-carousel'][replaceMe]/descendant::img[not(contains(@src,'rating'))]");
	By ModulecarouselImg        =By.xpath("//*[@class='module-carousel'][replaceMe]/descendant::img[not(contains(@src,'rating')) and not(contains(@src,'online'))]");
	By ModuleOnlineImg          =By.xpath("//*[@class='module-carousel'][replaceMe]/descendant::img[contains(@src,'online')]");
	By Modulecarouselcaption    =By.xpath("//*[@class='module-carousel'][replaceMe]/descendant::*[@class='caption']/span");
	By ModuleContentListSection    =By.xpath("//*[@class='module-contentList']");
	By ModuleContentListImg        =By.xpath("//*[@class='module-contentList'][replaceMe]/descendant::img[not(contains(@src,'rating')) and not(contains(@src,'online'))]");
	By ModuleContentListcaption    =By.xpath("//*[@class='module-contentList'][replaceMe]/descendant::*[@class='caption']/span");
	
	
	By CategoryTitle                   =By.xpath("//*[@id='category-title']/descendant::*[text()='replaceMe']");
	By ModuleContentListRanking        =By.xpath("//*[@class='module-contentListItem']/descendant::*[@class='ranking']");
	By ModuleContentListCarouselImg    =By.xpath("//*[@class='module-contentListItem']/descendant::img[not(contains(@src,'rating')) and not(contains(@src,'online'))]");
	By GalleryModuleContentListcaption =By.xpath("//*[@class='module-contentListItem']/descendant::*[@class='caption']/span");
	By SelectGameGallery               =By.xpath("//*[@class='module-contentListItem']/descendant::*[@class='caption']/span[text()='replaceMe']");
	By ModuleContentListDeveloper      =By.xpath("//*[@class='module-contentListItem']/descendant::*[contains(@class,'developer')]");
	By ModuleContentListratingImg      =By.xpath("//*[@class='module-contentListItem']/descendant::img[contains(@src,'rating')]");
	
	By OnlineImg                =By.xpath("//*[@class='module-contentListItem']/descendant::img[contains(@src,'online')]");
	By CategoryLink             =By.xpath("//*[text()='replaceMe']");
	By ClickOnNthCategoryButton =By.xpath("(//*[@id='categories']/descendant::*[contains(@class,'category-filter')])['replaceMe']");
	By BackIcon                 =By.xpath("//*[@id='ic-back']");
	By CloseIcon                =By.xpath("//*[@id='ic-close']");
	By CategoryList             =By.xpath("//*[@id='category-list']/descendant::div");
	By SelectCategoryName       =By.xpath("//*[@id='category-list']/descendant::*[contains(text(),'replaceMe')]");
	By SelectGameName           =By.xpath("//*[@class='caption']/descendant::*[text()='replaceMe']");
	By SelectGameNamewithIndex  =By.xpath("(//*[@class='caption']/descendant::span)['replaceMe']");
	By ListOfGameName           =By.xpath("//*[@class='caption']/descendant::span");
	
	By ProductBanner             =By.xpath("//*[@id='product-banner']");
	By Productthumbnail          =By.xpath("//*[@id='product-thumbnail']/descendant::img");
    By ProductTitle              =By.xpath("//*[@id='product']/descendant::h1");
    By ValidateProductTitle      =By.xpath("//*[@id='product']/h1[text()='replaceMe']");
	By ProductDev                =By.xpath("//*[@id='product']/descendant::h2");
	By ProductDesc               =By.xpath("//*[@id='product']/descendant::h3");
	By ProductDownloadImg        =By.xpath("//*[@id='product-button-download']/descendant::span");
	By DownloadGame              =By.xpath("//a[@id='popup-positive']/div");
	By ProductToPlayImg        =By.xpath("//*[@id='product-button-download']/descendant::span");
	By ProductDescription        =By.xpath("//*[@id='product-description']");
	By ReadMore                  =By.xpath("//*[@id='product-read-more']");
	By ScreenShotImg             =By.xpath("//*[contains(@href,'screenshot')]/img");
	By OtherRecomends            =By.xpath("//*[@class='module-header']/descendant::*[text()='Otros juegos recomendados ']");
	By ProductRating             =By.xpath("//*[@class='module-carousel']/descendant::img[not(contains(@src,'rating'))]");
	By FileSize                  =By.xpath("//*[@class='file-size']");
	By SubcribeGameTitle         =By.xpath("//*[@id='subscribe']/descendant::h1[text()='replaceMe']");
	By SubcribeGameImage         =By.xpath("//*[@id='subscribe']/descendant::h1[text()='replaceMe']/preceding-sibling::img");
	By SubscribeBoxText          =By.xpath("//*[@id='subscribe-box']/descendant::h2");
	By NegativeBtn               =By.xpath("//*[@class='button-negative']");
	By PositiveBtn               =By.xpath("//*[@class='button-positive']/span");
	By SubscribeTermsText        =By.xpath("//*[@id='subscribe']/descendant::p");
	By SubscribeTermsLink        =By.xpath("//*[@id='subscribe']/descendant::p/a[@href='/terms']");
	By AppPromotionText          =By.xpath("//*[@id='app-promotion']/div");
	By SubscribeConfirmationText =By.xpath("//*[@id='subscribe']/descendant::span");
	
	//By SubscribeConfirmationText =By.xpath("//*[@id='subscription-confirmation']/descendant::span");
  //  By SubscribeConfirmationImg  =By.xpath("//*[@id='subscription-confirmation']/descendant::img[contains(@src,'big_tick')]");
    By SubscribeConfirmationImg  =By.xpath("//*[@id='subscribe']/descendant::img[contains(@src,'ic-check.png')]");
  
    By DownloadSafeText          =By.xpath("//*[@id='download']/descendant::h1");
    By DownloadingText           =By.xpath("//*[@id='download']/descendant::h2");
    By DownloadingFileSize       =By.xpath("//*[@id='download']/descendant::h3");
    By DownloadingImage          =By.xpath("//*[contains(@class,'subscribe-image')]/descendant::img");
    By AutomaticDownloadText     =By.xpath("//*[@id='download']/descendant::p");
    By DownloadNote              =By.xpath("//*[@id='download-note']");
    By DownloadPoints            =By.xpath("//*[@id='subscribe']/descendant::li");
    By DownloadGreenBtn          =By.xpath("//*[@class='button-green']");
    By AppImg                    =By.xpath("//img[contains(@src,'app')]");
    By MovistarHeader            =By.xpath("//*[@id='header']/descendant::a");
    By MyDownloadedGame         =By.xpath("//*[@class='module-contentListItem']/descendant::img[not(contains(@src,'rating'))]");
    By MyDownloadedGameTitle    =By.xpath("//*[@class='module-contentListItem']/descendant::span");
    By EmptyDownloadButton      =By.xpath("//*[@class='button-green' and text()='Empieza a descargar']");
    By Footer        =By.xpath("//*[@id='footer']");
    By FooterLink    =By.xpath("//*[@id='footer']/descendant::a/div");
    
    By CookieNotice     =By.xpath("//*[@id='cookie-notice']/div");
    By Understoodbtn    =By.xpath("//*[text()='Entendido']");
    By MoreInfoBtn      =By.xpath("//a[@href='/cookies']/h1[text()='Más info']");
    By DownloadHeavyPopupContent     =By.xpath("//*[@id='popup-content']/descendant::div[1]");
    By DownloadHeavyPopupText        =By.xpath("//*[@id='popup-content']/descendant::div[2]");
    
    By CloseCookieNotice      =By.xpath("//*[@id='cookie-notice']/descendant::img");
    By CookiePageHeaders      =By.xpath("//*[@id='staticpage']/descendant::h3");
    By CookiesMoreInfo        =By.xpath("//*[@id='cookie-notice']/descendant::a");
    
    By ApppromotionClose        =By.xpath("//*[@id='app-promotion-close']/img");
    By AppPromotionGreenImg     =By.xpath("//*[@id='app-promotion']/descendant::img");
    
    //Ugames Content Flow
    By SubcribeText=By.xpath("//*[@id='sub']/p");
    By GameImg=By.xpath("//*[@class='product']/img");
    By GameText=By.xpath("//*[@id='screen1']/h1");
    By NoThanks=By.xpath("//*[@id='neg']");
    By ActiveBtn=By.xpath("//*[@id='displayPos']");

    
    By UIMErrorTitle        =By.xpath("//*[@class='error-title']");
    By UIMErrorParaText     =By.xpath("//*[@class='error']/descendant::p");
    By ContinueBtn          =By.xpath("//*[@class='btn btn-close-error btn-half' and @type='submit']");
    
    By SmalltextDigital          =By.xpath("//*[@class='select_option_wrap']/descendant::*[@class='small_text_digital']");
    By InputboxbigName           =By.xpath("//*[@class='select_box_big_name']");
    By REBICIRENLACEBtn          =By.xpath("//*[@id='btnSubmit' and @type='submit']");
    By SmallTextDigitalGrey      =By.xpath("//*[@class='small_text_digital_grey']");
    
    By InterNalLinkStaticTitle       =By.xpath("//*[@class='static-title']");
    By InterNalLinkTermsSection      =By.xpath(" //*[@class='terms-conditions']");
    By InterNalLinkStaticParaGraph   =By.xpath(" //*[@class='terms-conditions']/descendant::p");
    
    By ServicePresentationLogoText    =By.xpath("//*[@class='service-presentation']/descendant::*[text()='Movistar Juegos']");
    By Slideshow    =By.xpath("//*[@id='slideshow']");
    By ServicepresentationSubscribeText        =By.xpath("//*[@class='service-presentation'][2]/descendant::div[contains(@class,'gunmetal')]");
    
    By ServicepresentationSubscribeCategoryText        =By.xpath("//*[@class='service-presentation'][3]/descendant::div[contains(@class,'gunmetal')]");
    By ServicepresentationCategoryDescribeText        =By.xpath("//*[@class='service-presentation']/descendant::div[contains(@class,'steel')]");
    By ServicepresentationImg   =By.xpath("//*[@class='service-presentation']/descendant::img");
   
    By ServicepresentationSubscribeGreenText   =By.xpath("//*[@class='service-presentation']/descendant::*[contains(@class,'green')]");
    By BtnSubscribe1   =By.xpath("//*[@class='service-presentation-button-positive']/parent::a");
    By BtnViewGames1   =By.xpath("//a[@id='btnViewGames1']/descendant::div[@class='service-presentation-button-negative']");
   
    By ServicePresentationFooter   =By.xpath("//*[@id='service-presentation-footer']");
   	By ServicePresentationFooterWhiteText   =By.xpath("//*[@id='service-presentation-footer']/descendant::div[contains(@class,'white')]");
   	By BtnSubscribe2   =By.xpath("//*[@id='btnSubscribe2']/descendant::*[@class='button-positive green']");
    By BtnViewGames2   =By.xpath("//*[@id='btnViewGames2']/descendant::*[@class='button-negative']");
    By ServicepresentationTerms   =By.xpath("//*[@class='terms']");
    By ScrolldownArrows   =By.xpath("//img[contains(@src,'scroll-down-arrows.png')]");
    
    By SubcribeSpanText   =By.xpath("//*[@id='subscribe']/descendant::span");
    By EnjoyYourGameBtn   =By.xpath("//*[@id='subscribe']/descendant::*[@class='button-green']");
    By DevicesImage       =By.xpath("//*[@alt='Devices' and contains(@src,'app.jpg')]");
    By GooglePlayImage    =By.xpath("//*[@alt='GooglePlay' and contains(@src,'GooglePlay')]");
    By SlideShowBanner    =By.xpath("//*[@id='slideshow']");
 
    //Tourist portal for DM log
    By Subscribe_Active_Btn        =By.xpath("//*[@id='btnSubscribe']/div");
    By Banner_Img                  =By.xpath("//img[@class='banner-header-image']");
    By Subscription_Title       =By.xpath("//*[@class='subscription-title']");
    By Subscription_Text        =By.xpath("//*[@class='subscription-text']");
    By Subscribed_IMG           =By.xpath("//*[@class='tick-image']/img");
    By Subscribed_Text          =By.xpath("//*[@class='tick-text confirmation-header']");
    By Continue_Btn             =By.xpath("//*[contains(@class,'button')]");
    By BannerImg               =By.xpath("//img[@class='banner']");
    
    By SubscribeApppreviewImg               =By.xpath("//*[@class='preview subscribeapp']/descendant::img[@class='preview-image']");
    By SubscribeApppreviewTitle               =By.xpath("//*[@class='preview subscribeapp']/descendant::*[@class='title']");
    By SubscribeApppreviewRating              =By.xpath("//*[@class='preview subscribeapp']/descendant::*[@class='rating']");
    
    
    By EditorialConfirmContentImg              =By.xpath("//*[@class='subscribed']/descendant::*[@class='overlay-container']/img");		
    By EditorialConfirmContentTitle              =By.xpath("//*[@class='subscribed']/descendant::*[@class='overlay-content title']/h3");		
    By EditorialViewArticleBtn          =By.xpath("//*[@class='btn btn-buy btn-large']");
    
    
  //*[@class='preview subscribeapp']/descendant::*[@class='overlay-content title']/h3
  //*[@class='preview subscribeapp']/descendant::*[@class='overlay-container']/img
    
    ///MOD Header Xpath
    By ModHeaderSaveButton               =By.xpath("//*[contains(text(),'replaceMe')]/../../descendant::*[@tooltip='Save']");
    By ModHeaderEditButton               =By.xpath("//*[contains(text(),'replaceMe')]/../../descendant::*[@tooltip='Edit']");
    By ModHeaderDisableButton            =By.xpath("//*[contains(text(),'replaceMe')]/../../descendant::*[@tooltip='Disable']");
}
