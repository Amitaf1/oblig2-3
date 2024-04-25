"use strict";

let allTickets = [];
const ticketText = document.getElementById("billetter");

async function saveInput() {

    if (event) {
        event.preventDefault(); // Prevent default form submission behavior
    }

    const ticketForm = document.getElementById("ticketForm");

    const ticket = {
            film: document.getElementById("film").value,
            amount: document.getElementById("amount").value,
            fname: document.getElementById("fname").value,
            lname: document.getElementById("lname").value,
            telnr: document.getElementById("telnr").value,
            email: document.getElementById("email").value,
        },
        namePattern = /^[a-zA-Z\s]+$/,
        telPattern = /^\d{8}$/,
        emailPattern = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;

    clearErrors();

    try {
        const response = await fetch('http://localhost:8080/api/billetter/create', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(ticket)
        });

        if (response.ok) {
            const savedBillett = await response.json();
            console.log('Billett saved:', savedBillett);
            // Optionally update UI or perform other actions upon successful save
        } else {
            const errorMessage = await response.text(); // Get the error message from the response
            console.error('Failed to save billett:', errorMessage);
            // Handle error response (e.g., display error message to user)
        }
    } catch (error) {
        console.error('Error occurred during fetch:', error);
        // Handle fetch error (e.g., display error message to user)
    }

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
    fetch('http://localhost:8080/api/billetter/delete', {
        method: 'DELETE'
    })
        .then(response => {
            if (response.ok) {
                console.log('All tickets deleted successfully from backend.');
                // Clear the tickets displayed on the frontend
                allTickets = [];
                ticketText.textContent = "";
            } else {
                console.error('Failed to delete tickets from backend.');
                // Handle error scenario (e.g., display error message)
            }
        })
        .catch(error => {
            console.error('Error deleting tickets:', error);
            // Handle network or fetch error
        });
}


/*
function deleteAll() {
    allTickets = [];
    ticketText.textContent = "";
}

const deleteAll = () => {
    fetch('http://localhost:8080/api/billetter/delete', {
        method: 'DELETE'
    })
        .then(response => {
            if (response.ok) {
                console.log('All tickets deleted successfully.');
                // Perform any necessary UI updates
            } else {
                console.error('Failed to delete all tickets.');
            }
        })
        .catch(error => {
            console.error('Error deleting tickets:', error);
        });
};

*/