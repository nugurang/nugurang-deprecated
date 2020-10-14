import React from 'react';

import CardGrid from '../../components/CardGrid';

export default function CompTest() {

const cards = [
  {
    id: 1,
    title: "Article 1",
    content: "Content 1",
    image: "/static/images/sample_1.jpg",
  },
  {
    id: 2,
    title: "Article 2",
    content: "Content 2",
    image: "/static/images/sample_2.jpg",
  },
  {
    id: 3,
    title: "Article 3",
    content: "Content 3",
    image: "/static/images/sample_3.jpg",
  }
];

  return (
	<div>
	  <CardGrid cards={cards} />
	</div>
  );
}
