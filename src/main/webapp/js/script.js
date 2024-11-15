document
    .querySelector("#converter-form")
    .addEventListener("submit", submit);

function submit(event) {
    event.preventDefault();
    const amount = document.querySelector("#amount").value;
    if (amount === '' || isNaN(amount)) {
        alert("Please enter a valid amount.");
        return;
    }
    const baseCode = document.querySelector("#baseCode").value;
    const targetCode = document.querySelector("#targetCode").value;
    // fetch(`/convert?amount=${amount}&baseCode=${baseCode}&targetCode=${targetCode}`)
    //     .then(response => response.json())
    //     .then(data => {
    //         document.querySelector("#result").textContent = data.convertedAmount;
    //     });

    fetch('/convert', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({
            amount: amount,
            baseCode: baseCode,
            targetCode: targetCode
        })

    })
        .then(response => response.json())
        .then(data => {
            document.querySelector("#result").textContent = data.convertedAmount;
        });
}