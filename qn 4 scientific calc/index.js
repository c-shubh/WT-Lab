const gid = (id) => document.getElementById(id);
const display = gid("display");

const set = (value) => (display.value = value);
const get = () => display.value;
const ap = (val) => set(get() + val);
const eq = () => set(eval(get()));
const sin = () => set(Math.sin(parseFloat(get())));
const cos = () => set(Math.cos(parseFloat(get())));
const tan = () => set(Math.tan(parseFloat(get())));
const log10 = () => set(Math.log10(parseFloat(get())));

const nums = gid("nums");
for (let n of nums.children) {
  n.addEventListener("click", (e) => ap(e.target.innerText));
}
