/**
 * @param {Function} fn
 * @param {number} t
 * @return {Function}
 */
var throttle = function (fn, t) {
  let timeOut;
  let nextTimeToCall = 0;
  return function (...args) {
    let delay = Math.max(0, nextTimeToCall - Date.now());
    clearTimeout(timeOut);
    timeOut = setTimeout(() => {
      fn(...args);
      nextTimeToCall = Date.now() + t;
    }, delay);
  };
};

/**
 * const throttled = throttle(console.log, 100);
 * throttled("log"); // logged immediately.
 * throttled("log"); // logged at t=100ms.
 */