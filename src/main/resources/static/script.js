"use strict";

let allTickets = [];
const ticketText = document.getElementById("billetter");

function saveInput() {

    if (event) {
        event.preventDefault(); // Prevent default form submission behavior
    }

    const ticketForm = document.getElementById("ticketForm");

    const ticket = {
            film : document.getElementById("film").value,
            amount : document.getElementById("amount").value,
            fname : document.getElementById("fname").value,
            lname : document.getElementById("lname").value,
            telnr : document.getElementById("telnr").value,
            email : document.getElementById("email").value,
        },
        namePattern   = /^[a-zA-Z\s]+$/,
        telPattern    = /^\d{8}$/,
        emailPattern  = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;

    clearErrors();

    let error = false;

    // Validate film selection
    if (!ticket.film || ticket.film === "--Velg her--") {
        displayError("filmError", "Du må velge en gyldig film!");
        error = true;
    }

    // Validate amount
    if (!ticket.amount || isNaN(ticket.amount) || ticket.amount <= 0) {
        displayError("amountError", "Du må oppgi et gyldig antall billetter!");
        error = true;
    }

    // Validate first name
    if (!ticket.fname || !/^[a-zA-Z\s]+$/.test(ticket.fname)) {
        displayError("fnameError", "Du må oppgi et gyldig fornavn!");
        error = true;
    }

    // Validate last name
    if (!ticket.lname || !/^[a-zA-Z\s]+$/.test(ticket.lname)) {
        displayError("lnameError", "Du må oppgi et gyldig etternavn!");
        error = true;
    }


    // Validate phone number
    if (!ticket.telnr || !/^\d{8}$/.test(ticket.telnr)) {
        displayError("telnrError", "Du må oppgi et gyldig telefonnummer (8 siffer)!");
        error = true;
    }

    // Validate email
    if (!ticket.email || !/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(ticket.email)) {
        displayError("emailError", "Du må oppgi en gyldig e-postadresse!");
        error = true;
    }


    if (!error) {
        allTickets.push(ticket);
        const displayText = `
            Film: ${ticket.film},
            Antall: ${ticket.amount},
            Navn: ${ticket.fname} ${ticket.lname},
            Telefon: ${ticket.telnr},
            E-post: ${ticket.email}`;

        //const ticketText = document.getElementById("billetter");
        const displayElement = document.createElement("p");
        displayElement.textContent = displayText;
        ticketText.appendChild(displayElement);

        ticketForm.reset();
    }
}

function displayError(errorId, errorMessage) {
    const errMsg = document.createElement("span");
    errMsg.id = errorId;
    errMsg.classList.add("error");
    errMsg.textContent = errorMessage;

    const field = document.getElementById(errorId.replace("Error", ""));
    if (field) {
        field.insertAdjacentElement("afterend", errMsg);
    }
}

function clearErrors() {
    const errorElements = document.querySelectorAll(".error");
    errorElements.forEach((element) => element.remove());
}

function deleteAll() {
    allTickets = [];
    ticketText.textContent = "";
}

