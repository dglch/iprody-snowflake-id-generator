import http from 'k6/http';
import { sleep } from 'k6';

export const options = {
  vus: 10000,
  duration: '5m',
};

export default function () {
  http.get('http://snowflake.dev.local/next-id');
  sleep(0.1);
}
//k6 run load.js
