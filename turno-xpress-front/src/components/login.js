import React from 'react'

import PropTypes from 'prop-types'

import './login.css'

const Login = (props) => {
  return (
    <main id="main-container" className="login-container">
      <div className="login-container-col-left">
        <div className="login-container-col-header-left">
          <div className="login-container-title teleport-show">
            <div className="login-sub-container-title">
              <img
                alt={props.image_alt2}
                src={props.image_src2}
                className="login-image-title"
              />
            </div>
            <div className="login-container-subtitle">
              <h1 className="login-greating-h1">{props.heading}</h1>
              <span className="login-downtext">
                <span>Nos alegra verte de nuevo.</span>
                <br></br>
              </span>
            </div>
          </div>
        </div>
        <div className="login-container-col-main-left">
          <div className="login-container-form">
            <form className="login-login-form">
              <div id="inputMail" className="login-sub-container-mail">
                <div className="login-container-input-email input">
                  <img
                    alt={props.image_alt3}
                    src={props.envelopeInputEmail_image}
                    className="login-envelope-image-input"
                  />
                  <input
                    type="text"
                    placeholder={props.EmailInput}
                    autoComplete="off"
                    className="login-input-email"
                  />
                </div>
              </div>
              <div className="login-sub-container-password">
                <div className="login-container-input-password input">
                  <img
                    alt={props.image_alt4}
                    src={props.image_src4}
                    className="login-image-lock-password"
                  />
                  <input
                    type="password"
                    placeholder="Contraseña"
                    outline="none"
                    className="login-input-password input"
                  />
                  <img
                    alt={props.showPasswors_image}
                    src={props.image_src5}
                    id="showPasswordBtn"
                    className="login-image-show-password"
                  />
                </div>
              </div>
              <div className="login-container-forgot-password-link">
                <a
                  href={props.ForgotPassword_input}
                  target="_blank"
                  rel="noreferrer noopener"
                  className="login-link"
                >
                  {props.text2}
                </a>
              </div>
              <button type="submit" className="login-button button">
                {props.LoginButton}
              </button>
            </form>
          </div>
        </div>
        <div className="login-container-line-left">
          <div className="login-sub-container-line-left"></div>
          <div className="login-sub-container-circle">
            <svg
              viewBox="0 0 877.7142857142857 1024"
              className="login-circle-icon"
            >
              <path d="M438.857 146.286c-201.714 0-365.714 164-365.714 365.714s164 365.714 365.714 365.714 365.714-164 365.714-365.714-164-365.714-365.714-365.714zM877.714 512c0 242.286-196.571 438.857-438.857 438.857s-438.857-196.571-438.857-438.857 196.571-438.857 438.857-438.857v0c242.286 0 438.857 196.571 438.857 438.857z"></path>
            </svg>
          </div>
          <div className="login-sub-container-line-right"></div>
        </div>
        <div className="login-container-footer">
          <button type="submit" className="login-button-google button">
            <img
              alt={props.image_alt1}
              src={props.image_src1}
              className="login-image"
            />
          </button>
          <div className="login-container1">
            <span className="login-text2">{props.text}</span>
            <a
              href={props.link_text}
              target="_blank"
              rel="noreferrer noopener"
              className="login-link1"
            >
              {props.text1}
            </a>
          </div>
        </div>
      </div>
      <img
        alt={props.image_alt}
        src={props.image_src}
        className="login-image1"
      />
    </main>
  )
}

Login.defaultProps = {
  showPasswors_image: 'image',
  envelopeInputEmail_image: '/envelopeicon.svg',
  EmailInput: 'Correo eléctronico',
  ForgotPassword_input: 'https://example.com',
  image_src: '/d00910a2f58ebd9be8b4590c673efe1c-1500h.png',
  image_src4: '/lcokicon.svg',
  LoginButton: 'Iniciar Sesión',
  image_alt4: 'image',
  image_alt3: 'image',
  image_alt1: 'image',
  image_src5: '/eyeicon.svg',
  link_text: 'https://example.com',
  image_src2: '/turnoxpresstitle.svg',
  image_src1: '/google_ic.svg',
  text1: 'Registrarse',
  heading: '¡Hola nuevamente! 👋🏻',
  text: '¿No tienes cuenta? \n',
  text2: '¿Olvidaste tu contraseña?',
  image_alt: 'image_pull',
  image_alt2: 'image',
}

Login.propTypes = {
  showPasswors_image: PropTypes.string,
  envelopeInputEmail_image: PropTypes.string,
  EmailInput: PropTypes.string,
  ForgotPassword_input: PropTypes.string,
  image_src: PropTypes.string,
  image_src4: PropTypes.string,
  LoginButton: PropTypes.string,
  image_alt4: PropTypes.string,
  image_alt3: PropTypes.string,
  image_alt1: PropTypes.string,
  image_src5: PropTypes.string,
  link_text: PropTypes.string,
  image_src2: PropTypes.string,
  image_src1: PropTypes.string,
  text1: PropTypes.string,
  heading: PropTypes.string,
  text: PropTypes.string,
  text2: PropTypes.string,
  image_alt: PropTypes.string,
  image_alt2: PropTypes.string,
}

export default Login
