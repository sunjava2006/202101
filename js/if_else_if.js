var score = Math.round(Math.random() * 100);
console.log("rcore: " + score);

var grad;

if (score >= 90) {
    grad = "Well";
} else if (score >= 80) {
    grad = "good";
} else if (score >= 60) {
    grad = "normal"
}
else {
    grad = "fail";
}
console.log(grad);