import { defineConfig } from 'vite'
import react from '@vitejs/plugin-react-swc'
import path from 'path';

// https://vitejs.dev/config/
export default defineConfig({
  plugins: [react()],
  resolve: {
    alias: {
      // '@components': path.resolve(__dirname, 'src/components'),
      // '@pages': path.resolve(__dirname, 'src/pages/'),
      '@': path.resolve(__dirname, 'src'), // '@'를 'src'로 매핑
    },
  },
});
