
function convertJsonIntoPublications(strData){
    divParent = document.getElementById('row-list')
    divParent.innerHTML = ''
    const jsonData = JSON.parse(strData)

    for(let i = jsonData.length - 1; i >= 0; i--) {
        var divCol = document.createElement('div')
        divCol.className = "col-md-4 mb-4"

        let divCard = document.createElement('div');
        divCard.className="card"

        let img = document.createElement('img')
        img.className = "card-img-top"
        img.src = jsonData[i].image
        img.alt = "Card image cap"

        let divBody = document.createElement('div')
        divBody.className = "card-body"

        let h5 = document.createElement('h5')
        h5.className = "card-title"
        h5.innerText = jsonData[i].title

        let p = document.createElement('p')
        p.className = "card-text"
        p.innerText = jsonData[i].description

        let a = document.createElement('a')
        a.className = "btn btn-primary"
        a.href = "/publication?publ_id=" + jsonData[i].id
        a.innerText = 'Read'

        let pGenre = document.createElement('p')
        pGenre.className = 'text-black-50 text-end'
        pGenre.innerText = jsonData[i].genre
        // spanGenre.style.marginLeft = "13.5rem"



        divBody.appendChild(h5)
        divBody.appendChild(p)
        divBody.appendChild(a)
        divBody.appendChild(pGenre)

        divCard.appendChild(img)
        divCard.appendChild(divBody)

        divCol.appendChild(divCard)

        divParent.appendChild(divCol)
    }

    // for (var i = 0; i < jsonData.counters.length; i++) {
    //     var counter = jsonData.counters[i];
    // }
}