/** @type {import('tailwindcss').Config} */
export default {
	content: ["./index.html", "./src/**/*.{js,ts,jsx,tsx}"],
	theme: {
		extend: {
            colors: {
                'semesBlue': {
                    DEFAULT: '#004F9F',
                },
            }
        },
	},
	plugins: [],
};
