import React from 'react'

import { Helmet } from 'react-helmet'

import Login from '../components/login'
import './home.css'

const Home = (props) => {
  return (
    <div className="home-container">
      <Helmet>
        <title>TurnoXpress</title>
        <meta property="og:title" content="TurnoXpress" />
      </Helmet>
      <Login></Login>
    </div>
  )
}

export default Home
