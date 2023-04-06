
<!DOCTYPE html>

<html lang="en">
<head>

<style type="text/css">

.gradient-text {
    background-color: #f3ec78;
    background-image: linear-gradient(45deg, #f3ec78, #af4261);
    background-size: 100%;
    -webkit-background-clip: text;
    -moz-background-clip: text;
    -webkit-text-fill-color: transparent;
    -moz-text-fill-color: transparent;
}

.gradient-custom-2 {
/* fallback for old browsers */
background: #fccb90;

/* Chrome 10-25, Safari 5.1-6 */
background: -webkit-linear-gradient(to right, #ee7724, #d8363a, #dd3675, #b44593);

/* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */
background: linear-gradient(to right, #ee7724, #d8363a, #dd3675, #b44593);
}

@media (min-width: 768px) {
.gradient-form {
height: 100vh !important;
}
}
@media (min-width: 769px) {
.gradient-custom-2 {
border-top-right-radius: .3rem;
border-bottom-right-radius: .3rem;
}
}


  svg:hover {
  transform: scale(1.5);
}
  </style>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>HomePage</title>
<!-- CSS only -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi"
	crossorigin="anonymous">
</head>
<body class="bg-dark">
	<!-- JavaScript Bundle with Popper -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
		crossorigin="anonymous"></script>


	<!-- Drop down -->

	<div class="collapse" id="navbarToggleExternalContent">
		<div class="bg-white p-4">
			<h3 class="text-black h4" style="font-family: Ink Free , Times New Roman , Times, serif;">
				<b>Greetings !</b>
			</h3>
			<span class="text-muted">The Platform provides the functionality of finding hidden knowledge from your data.
			 Just pass in the data and find hidden knowledge ! </span>
		</div>
	</div>

	<!--
 my nav bar
 -->
	<nav class="navbar sticky-md-top navbar-dark bg-black">
		<div class="container-fluid">
			<button class="navbar-toggler btn-sm" type="button"
				data-bs-toggle="collapse"
				data-bs-target="#navbarToggleExternalContent"
				aria-controls="navbarToggleExternalContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<!---->
				<span class="navbar-toggler-icon "></span>

			</button>
			<a class="navbar-brand" data-bs-toggle="tooltip"
				title="Click this Logo to navigate to Home page"
				style="text-align: center" href="">
				<h5 class="d-inline" style="font-family: Segoe Script , Times New Roman , Times, serif;">Pattern</h5>
					<h3 class="d-inline gradient-text"> Excavator</h3>

			</a>

			<form class="d-flex"
				style="text-align: right" role="button">
				<a class="btn btn-outline-light me-md-3" href="login"
					data-bs-toggle="tooltip"
					title="Click this button to navigate to login page" role="button"
					style="--bs-btn-padding-y: .5rem; --bs-btn-padding-x: 2.5rem; --bs-btn-font-size: 1rem;">SignIn</a> <a
					class="btn btn-outline-light" href="register"
					data-bs-toggle="tooltip"
					title="Click this button to navigate to register page" role="button"
					style="--bs-btn-padding-y: .5rem; --bs-btn-padding-x: 2.5rem; --bs-btn-font-size: 1rem;">SignUp</a>
			</form>
		</div>

	</nav>


	<!--  lacchi navbar
  	<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top" style="opacity: ;">
  <div class="container-fluid">

    <a class="navbar-brand" href="HomePage">SDL </a>
    <button class="navbar-toggler " type="button" data-bs-toggle="collapse" data-bs-target="#navbarToggleExternalContent" aria-controls="navbarToggleExternalContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">

          <a routerLink="" class="nav-link active" aria-current="page">Home</a>
        </li>
        <li class="nav-item">

          <a class="nav-link active" routerLink="/about">About</a>
        </li>

        <li class="nav-item">
          <a class="nav-link active" routerLink="/contact">Contact Us</a>
        </li>
      </ul>

    </div>
��</div>
</nav>
-->


	<!--</div>
	  <div class="card text-bg-dark">
  		<img src="https://images.pexels.com/photos/950241/pexels-photo-950241.jpeg?auto=compress&amp;cs=tinysrgb&amp;dpr=1&amp;w=500" class="card-img" alt="...">
  		<div class="card-img-overlay">
    	<h5 class="card-title">About Us</h5>
    	<p class="card-text">This is a wider card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.............................</p>
    	<p class="card-text"><small class="text-muted">Last updated 3 mins ago</small></p>
  		</div>
	</div>-->


	<!-- SLIDE
	style="padding-left:20px ; padding-right:20px ;�"
	-->
	<div class="card text-bg-dark bg-dark ">
		<div class="card-header">

			<div id="carouselExampleDark" class="carousel slide p-4"
				data-bs-ride="carousel">
				<div class="carousel-indicators p-4">
					<button type="button" data-bs-target="#carouselExampleDark"
						data-bs-slide-to="0" class="active" aria-current="true"
						aria-label="Slide 1"></button>
					<button type="button" data-bs-target="#carouselExampleDark"
						data-bs-slide-to="1" aria-label="Slide 2"></button>
					<button type="button" data-bs-target="#carouselExampleDark"
						data-bs-slide-to="2" aria-label="Slide 3"></button>
					<button type="button" data-bs-target="#carouselExampleDark"
						data-bs-slide-to="3" aria-label="Slide 4"></button>
					<button type="button" data-bs-target="#carouselExampleDark"
						data-bs-slide-to="4" aria-label="Slide 5"></button>
				</div>
				<div class="carousel-inner border border-5">
					<div class="carousel-item active">
						<img
							src="https://images.pexels.com/photos/225769/pexels-photo-225769.jpeg"
							class="d-block w-100" alt="slide 1">
					</div>
					<div class="carousel-item">
						<img
							src="https://images.pexels.com/photos/164686/pexels-photo-164686.jpeg?auto=compress&amp;cs=tinysrgb&amp;w=1260&amp;h=750&amp;dpr=1"
							class="d-block w-100" alt="slide 2">
					</div>
					<div class="carousel-item">
						<img
							src="https://images.pexels.com/photos/5561923/pexels-photo-5561923.jpeg?auto=compress&amp;cs=tinysrgb&amp;w=1260&amp;h=750&amp;dpr=1"
							class="d-block w-100" alt="slide 3">
					</div>
					<div class="carousel-item">
						<img
							src="https://images.pexels.com/photos/5697255/pexels-photo-5697255.jpeg?auto=compress&amp;cs=tinysrgb&amp;w=1260&amp;h=750&amp;dpr=1"
							class="d-block w-100" alt="slide 4">
					</div>
					<div class="carousel-item">
						<img
							src="https://images.pexels.com/photos/1370294/pexels-photo-1370294.jpeg?auto=compress&amp;cs=tinysrgb&amp;w=1260&amp;h=750&amp;dpr=1"
							class="d-block w-100" alt="slide 5">
					</div>
				</div>
				<button class="carousel-control-prev" type="button"
					data-bs-target="#carouselExampleDark" data-bs-slide="prev">
					<span class="carousel-control-prev-icon" aria-hidden="true"></span>
					<span class="visually-hidden">Previous</span>
				</button>
				<button class="carousel-control-next" type="button"
					data-bs-target="#carouselExampleDark" data-bs-slide="next">
					<span class="carousel-control-next-icon" aria-hidden="true"></span>
					<span class="visually-hidden">Next</span>
				</button>

			</div>
			<div class="card-body">
				<br> <br> <br>
				<h1 class="card-title" style="font-family: Segoe Script , Times New Roman , Times, serif;">
					<i class="font-effect-emboss">What We Offer... </i>
				</h1>
				<hr>
				<!-- placeholder
    <p class="placeholder-glow">
  	<span class="placeholder col-12 placeholder-xs bg-light"></span>
	</p>
    -->
				<br>
				<!-- card 1 -->
				<div class="card mb-3 bg-black">
					<div class="row g-0">
						<div class="col-md-8">
							<div class="card-body text-light">
								<br> <br>
								<h3 class="card-title text-light fs-2"
									style="font-family: Candara , Times New Roman , Times, serif;">
									<i>Built for <small class="text-muted">Speed</small> and <small
										class="text-muted">Security</small>
									</i>

								</h3>
								<hr>
								<br>
								<p class="card-text-light">We provide you with the functionality to hit
								our API on your domain making the process rather faster also your data is only
								accessible to you not even us thereby vanquishing any security concerns.
</p>

							</div>
						</div>
						<div class="col-md-4">
							<img
								src="https://img1.wsimg.com/cdn/Image/All/AllChannelsFoS/1/All/5a83999b-cb23-4b51-81ec-a14a76b17a65/img-feat-pro.jpg"
								class="img-fluid rounded-start" alt="image1">
						</div>
					</div>
				</div>

				<br> <br>
				<!-- card 2 -->

				<div class="card mb-3 bg-black ">
					<div class="row g-0">

						<div class="col-md-4">
							<img src="https://i.ibb.co/x5VdJhP/image-3.png"
								class="img-fluid rounded-start" alt="image1">
						</div>

						<div class="col-md-8">
							<div class="card-body text-light">
								<br> <br>
								<h3 class="card-title text-light fs-2"
									style="font-family: Candara , Times New Roman , Times, serif;">
									<i>Enhanced for <small class="text-muted">Easy</small>
										usage and <small class="text-muted">Efficient</small> working
									</i>
								</h3>
								<hr>
								<br>
								<p class="card-text-light">Our Algorithm is designed to mine the patterns in maximum
								efficiency also our services are easy to use since you just need to hit an API making
								it user friendly.
									</p>

							</div>
						</div>

					</div>
				</div>

				<br> <br>
				<!-- Card 3 -->
				<div class="card mb-3 bg-black">
					<div class="row g-0">
						<div class="col-md-8">
							<div class="card-body text-light">
								<br> <br>
								<h3 class="card-title text-light fs-2"
									style="font-family: Candara">
									<i>Providing simple insights to <small class="text-muted">Grow</small>
										your <small class="text-muted">Business</small>
									</i>
								</h3>
								<hr>
								<br>
								<p class="card-text-dark">With simple steps such as mining frequent products
								that are bought together can help you grow your business and your profits by large extent.
									</p>

							</div>
						</div>
						<div class="col-md-4">
							<img
								src="https://img1.wsimg.com/cdn/Image/All/AllChannelsFoS/1/All/5c8c5594-b125-4de5-8151-36b3d60ef6b7/img-feat-reseller.jpg"
								class="img-fluid rounded-start" alt="image1">
						</div>
					</div>
				</div>


				<!-- card 4

				<div class="card mb-3 bg-black border border-1">
					<div class="row g-0">

						<div class="col-md-4">
							<img src="https://i.ibb.co/jvXSSwd/image-3.png"
								class="img-fluid rounded-start" alt="image1">
						</div>

						<div class="col-md-8">
							<div class="card-body text-light">
								<br> <br>
								<h3 class="card-title text-light fs-2"
									style="font-family: Candara">
									<i>Enhanced for <small class="text-muted">Easy</small>
										usage and <small class="text-muted">Efficient</small> working
									</i>
								</h3>
								<p class="card-text-light">This is a wider card with
									supporting text below as a natural lead-in to additional
									content. This content is a little bit longer.
									........................................................................................................................................................
									.............................................................................................</p>
								<p class="card-text">
									<small class="text-muted">Last updated 3 mins ago</small>
								</p>
							</div>
						</div>

					</div>
				</div>
				<br> <br>-->

				<!-- card 5

				<div class="card mb-3 bg-light border border-1 border-dark ">
					<div class="row g-0">

						<div class="col-md-4">
							<img src="https://i.ibb.co/jvXSSwd/image-3.png"
								class="img-fluid rounded-start" alt="image1">
						</div>

						<div class="col-md-8">
							<div class="card-body text-dark">
								<br> <br>
								<h3 class="card-title text-dark fs-2"
									style="font-family: Candara">
									<i>Enhanced for <small class="text-muted">Easy</small>
										usage and <small class="text-muted">Efficient</small> working
									</i>
								</h3>
								<p class="card-text-dark">This is a wider card with
									supporting text below as a natural lead-in to additional
									content. This content is a little bit longer.
									........................................................................................................................................................
									.............................................................................................</p>
								<p class="card-text">
									<small class="text-muted">Last updated 3 mins ago</small>
								</p>
							</div>
						</div>

					</div>
				</div>-->

				<!-- paragraph  -->
				<br> <br> <br>
				<h1 class="border-bottom border-1 p-3"
					style="text-align: center; font-family: Candara Light , Times New Roman , Times, serif;">
					<b>How We Do It</b> :
				</h1>
				<br>
				<h2 class="bg-black" style="text-align: center; font-family: 'Times New Roman' , Times, serif;">
				<i class="text-muted">We follow the following</i> <i>three simple steps </i><i class="text-muted">to make it happen :</i>
				</h2>
				 <br>
				 <br>
				 <br>
				<blockquote class="blockquote mb-0" style="text-align: center">

					<svg xmlns="http://www.w3.org/2000/svg" width="24" height="28" fill="currentColor" class="bi bi-1-square-fill" viewBox="0 0 20 24">
  					<path d="M2 0a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2H2Zm7.283 4.002V12H7.971V5.338h-.065L6.072 6.656V5.385l1.899-1.383h1.312Z"/>
					</svg>

					<h3 class="d-inline" style="text-align: center; font-family: Times New Roman">
						<i>First Step</i>
					</h3>
					<footer class="blockquote-footer"> </footer>
					<p class="card-text"
						style="text-align: center; font-family: Candara Light">
						<i>For the first step involved we ask you to provide us with the data on which pattern mining needs to be performed
						<br>also we collect these data through secured REST Apis thereby maintaining your data security and integrity.
						</i>
					</p>
					<!--  -->
				</blockquote>
				<br>
				<hr>
				<br>
				<blockquote class="blockquote mb-0" style="text-align: center">

				<svg xmlns="http://www.w3.org/2000/svg" width="30" height="30" fill="currentColor" class="bi bi-2-square-fill" viewBox="0 0 20 24">
  				<path d="M2 0a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2H2Zm4.646 6.24v.07H5.375v-.064c0-1.213.879-2.402 2.637-2.402 1.582 0 2.613.949 2.613 2.215 0 1.002-.6 1.667-1.287 2.43l-.096.107-1.974 2.22v.077h3.498V12H5.422v-.832l2.97-3.293c.434-.475.903-1.008.903-1.705 0-.744-.557-1.236-1.313-1.236-.843 0-1.336.615-1.336 1.306Z"/>
				</svg>

					<h3 class="d-inline" style="text-align: center; font-family: 'Times New Roman' , Times, serif;">
						<i>Second Step</i>
					</h3>
					<footer class="blockquote-footer"> </footer>
					<p class="card-text"
						style="text-align: center; font-family: Candara Light">
						<i>We implement our algorithm to mine strong associations from your data
						<br>our algorithm is designed for utmost accuracy and efficiency thus minimizing the risk of wrong results generation.
						</i>
					</p>
					<!--  -->
				</blockquote>
				<br>
				<hr>
				<br>
				<blockquote class="blockquote mb-0" style="text-align: center">
				<svg xmlns="http://www.w3.org/2000/svg" width="30" height="30" fill="currentColor" class="bi bi-3-square-fill" viewBox="0 0 20 24">
  <path d="M2 0a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2H2Zm5.918 8.414h-.879V7.342h.838c.78 0 1.348-.522 1.342-1.237 0-.709-.563-1.195-1.348-1.195-.79 0-1.312.498-1.348 1.055H5.275c.036-1.137.95-2.115 2.625-2.121 1.594-.012 2.608.885 2.637 2.062.023 1.137-.885 1.776-1.482 1.875v.07c.703.07 1.71.64 1.734 1.917.024 1.459-1.277 2.396-2.93 2.396-1.705 0-2.707-.967-2.754-2.144H6.33c.059.597.68 1.06 1.541 1.066.973.006 1.6-.563 1.588-1.354-.006-.779-.621-1.318-1.541-1.318Z"/>
</svg>
					<h3 class="d-inline" style="text-align: center; font-family:'Times New Roman' , Times, serif;">
						<i>Third Step</i>
					</h3 >
					<footer class="blockquote-footer"> </footer>
					<p class="card-text"
						style="text-align: center; font-family: Candara Light">
						<i>After implementation of our algorithm we provide you with the strong associations present in your data
						<br>which definitely will help you implement better approach to your business ideas
						<br>also we provide these results to you through secure Apis hence not leaving any security concerns unchecked.
						</i>
					</p>
					<!--  -->
				</blockquote>
				<br>
				<hr>
				<br> <br> <br>
			</div>
		</div>

		<!-- about -->
		<div class="card-group">
			<div class="card">

				<div class="card-body text-dark">
					<h5 class="card-title text-dark">Abhishek Vengurlekar</h5>
					<p class="card-text">Email :- 19bc102@ietdavv.edu.in
					<br>Mob. :- 9131070161</p>

				</div>
			</div>
			<div class="card">

				<div class="card-body text-dark">
					<h5 class="card-title">Arpit Parahar</h5>
					<p class="card-text">Email :- 19bc116@ietdavv.edu.in
					<br>Mob. :- 6266022718</p>

				</div>
			</div>
			<div class="card">

				<div class="card-body text-dark">
					<h5 class="card-title">Kuhagra Garg</h5>
					<p class="card-text">Email :- 19bc126@ietdavv.edu.in.
					<br>Mob. :- 8989505109</p>

				</div>
			</div>
		</div>
		<div class="bg-black" style="text-align: center">
			<br>
			<h1 class="border-bottom border-1 p-4 m-3" style="text-align: left">About us</h1>
			<br> <br> <br>
			<p class="card-text" style="text-align: center">
				We are a bunch of college students who were fascinated with Data Mining
				<br>and the concepts of finding hidden patterns inside the data ,
				<br>The idea behind the project is to find the useful information hidden to the
				human eye from abundance of data.
			</p>
			<br> <br> <br> <br>
		</div>
	</div>
	<div class="card-footer text-center p-1 bg-info fs-5"
		style="font-family: Bahnschrift Light , Times New Roman , Times, serif;">
		<p>
			For any queries or website related information please contact us on :
			<small class="card-footer text-center text-muted fs-4"
				style="font-family: Candara , Times New Roman , Times, serif;">+91 8989505109</small> or drop a mail
			to us at : <small class="card-footer text-center text-muted fs-4"
				style="font-family: Candara , Times New Roman , Times, serif;"> 19bcs126@ietdavv.edu.in</small>
		</p>
	</div>
</body>

</html>