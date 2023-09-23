import React, { useState } from "react";
import '../CSS/gallery.css'; // Import your custom CSS for styling

export default function Gallery() {
  const images = [
    '/images/Slide1.jpg',
    '/images/Slide2.jpg',
    '/images/Slide3.jpg',
    '/images/Slide4.jpg',
    '/images/Slide5.jpg',
    '/images/Slide6.jpg',
    '/images/Slide7.jpg',
    '/images/Slide8.jpg',
    '/images/Slide9.jpg',
    '/images/Slide10.jpg'
    // Add more image URLs here
  ];

  const [modalImage, setModalImage] = useState(null);

  const openModal = (imageUrl) => {
    setModalImage(imageUrl);
  };

  const closeModal = () => {
    setModalImage(null);
  };

  return (
    <div className="image-gallery">
      {images.map((imageUrl, index) => (
        <div key={index} className="image-item">
          <img
            src={imageUrl}
            alt={`Image ${index + 1}`}
            onClick={() => openModal(imageUrl)}
          />
        </div>
      ))}

      {modalImage && (
        <div className="modal">
          <div className="modal-content">
            <span className="close" onClick={closeModal}>&times;</span>
            <img src={modalImage} alt="Enlarged Image" />
          </div>
        </div>
      )}
    </div>
  );
}


