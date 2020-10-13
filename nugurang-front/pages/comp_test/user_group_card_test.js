import React from 'react';

import UserGroupCard from '../../components/UserGroupCard';

export default function CompTest() {

const card = {
  id: 1,
  title: "Article 1",
  content: "Article 1 content",
  image: "/static/images/sample_1.jpg",
  users:[
    {
      id: 1,
      name: "User 1",
      image: "/static/images/sample_2.jpg",
    },
    {
      id: 2,
      name: "User 2",
      image: "/static/images/sample_3.jpg",
    },
    {
      id: 3,
      name: "User 3",
      image: "/static/images/sample_4.jpg",
    },
    {
      id: 4,
      name: "User 4",
      image: "/static/images/sample_5.jpg",
    },
  ]
};

  return (
	<div>
	  <UserGroupCard card={card} />
	</div>
  );
}
