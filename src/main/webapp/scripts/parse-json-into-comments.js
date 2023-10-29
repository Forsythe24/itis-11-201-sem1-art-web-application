function parseJsonIntoComments(strData){
    const jsonData = JSON.parse(strData)
    for(let i = jsonData.length - 1; i >= 0; i--) {
        let liRow = document.createElement('li')
        liRow.className = 'row clearfix'

        let divIcon = document.createElement('div')
        divIcon.className = '"icon-box col-md-1 col-4"'

        let img = document.createElement('img')
        img.className = 'img-fluid img-thumbnail'
        img.src = jsonData[i].image
        img.alt = "Awesome Image"

        let divText = document.createElement('div')
        divText.className = 'text-box col-md-10 col-8 p-l-0 p-r0'

        let h5 = document.createElement('h5')
        h5.className = 'm-b-0'
        h5.innerText = jsonData[i].username

        let pText = document.createElement('p')
        pText.innerText = jsonData[i].text
        pText.style.marginBottom = "0.5rem"
        pText.style.color = "black"
        pText.style.fontSize = "20px"

        let pDate = document.createElement('p')

        let iDate = document.createElement('i')
        iDate.innerText = jsonData[i].time + " " + jsonData[i].date

        pDate.appendChild(iDate)

        divText.appendChild(h5)
        divText.appendChild(pText)
        divText.appendChild(pDate)

        divIcon.appendChild(img)

        liRow.append(divIcon)
        liRow.appendChild(divText)

        divParent = document.getElementById('comment-container')
        divParent.appendChild(liRow)
    }
}