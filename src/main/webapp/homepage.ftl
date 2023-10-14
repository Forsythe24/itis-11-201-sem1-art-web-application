<html lang="en">
<#include "/resources/css/styles.css">
<#include "base.ftl">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <title>Scrolling Nav - Start Bootstrap Template</title>
</head>

<#macro title>Home page</#macro>
<body id="page-top">
<!-- Navigation-->
<#macro navbar>
    <button
            class="navbar-toggler"
            type="button"
            data-mdb-toggle="collapse"
            data-mdb-target="#navbarRightAlign"
            aria-controls="navbarRightAlign"
            aria-expanded="false"
            aria-label="Toggle navigation"
    >
        <i class="fas fa-bars"></i>
    </button>

    <div class="collapse navbar-collapse" id="navbarRightAlign">
        <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
            <li class="nav-item">
                <a class="nav-link active" aria-current="page" href="/userinfo">Sign Up</a>
            </li>
            <li class="nav-item">
                <a class="nav-link active" aria-current="page" href="/signin">Sign In</a>
            </li>
        </ul>
    </div>
    </div>
</#macro>
<#macro content>
</#macro>
<div class="container-fluid" style="background-color: #D2B48C; background-image: url('https://images.wallpaperscraft.com/image/single/pen_petals_letter_189319_1920x1080.jpg'); background-repeat: no-repeat; background-size: 100%">

    <div class = "container-fluid" >
        <div class="container py-5 h-100">
            <div class="row d-flex justify-content-center align-items-center">
                <div class="col-12 col-md-8 col-lg-6 col-xl-5">
                    <div class="row gx-4 justify-content-center">
                        <div class="col-lg-8">
                            <header class="text-white">
                                <div class="container px-4 text-center">
                                    <h1 class="fw-bolder" style="font-size: 400%">LibrArea</h1>
                                    <p class="lead">The place where authors and readers get to meet</p>
                                    <a class="btn btn-lg" href="#about" style="background-color: #D2B48C">About us</a>
                                </div>
                            </header>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </div>
    <section id="about">
        <div class="container-fluid">
            <div class="row gx-4 justify-content-center">
                <div class="col-lg-8">
                    <h2>About this page</h2>
                    <p class="lead">This is a great place to talk about your webpage. This template is purposefully unstyled so you can use it as a boilerplate or starting point for you own landing page designs! This template features:</p>
                    <ul>
                        <li>Clickable nav links that smooth scroll to page sections</li>
                        <li>Responsive behavior when clicking nav links perfect for a one page website</li>
                        <li>Bootstrap's scrollspy feature which highlights which section of the page you're on in the navbar</li>
                        <li>Minimal custom CSS so you are free to explore your own unique design options</li>
                    </ul>
                </div>
            </div>
        </div>
    </section>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>