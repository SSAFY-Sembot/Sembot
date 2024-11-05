/** @type {import('tailwindcss').Config} */
module.exports = {
  darkMode: ["class"],
  content: ["./index.html", "./src/**/*.{js,ts,jsx,tsx}"],
  theme: {
  	extend: {
  		colors: {
  			semesBlue: {
  				DEFAULT: '#004F9F'
  			},
			}
  	}
  },
  plugins: [
    require('@tailwindcss/typography'),
    // ...
  ],
}

