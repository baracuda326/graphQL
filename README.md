# graphQL
{
allApartments{
id
}
apartment(id : "1"){
id
title
}
}
![](https://res.cloudinary.com/dvde7hpxw/image/upload/v1600627719/graphQL1_j0w99u.jpg)
![](https://res.cloudinary.com/dvde7hpxw/image/upload/v1600627719/graphQL2_vfky0s.jpg)
{
  "allApartments": [
    {
      "id": "1"
    },
    {
      "id": "2"
    }
  ],
  "apartment": {
    "id": "1",
    "title": "title test"
  }
}