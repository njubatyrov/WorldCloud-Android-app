function wordCloud(data, weights) {
    var fill = d3.scale.category20();

    var layout = d3.layout.cloud()
        .size([350, 350])
        .words(data.map(function(d, index) {
          return {text: d, size: weights[index]};
        }))
        .padding(1)
        .rotate(function() { return 0; })
        .font("Impact")
        .fontSize(function(d) { return d.size; })
        .timeInterval([2])
        .on("end", draw);

    layout.start();

    function draw(words) {
      d3.select("body").append("svg")
          .attr("width", layout.size()[0])
          .attr("height", layout.size()[1])
        .append("g")
          .attr("transform", "translate(" + layout.size()[0] / 2 + "," + layout.size()[1] / 2 + ")")
        .selectAll("text")
          .data(words)
        .enter().append("text")
          .style("font-size", function(d) { return d.size + "px"; })
          .style("font-family", "Impact")
          .style("fill", function(d, i) { return fill(i); })
          .attr("text-anchor", "middle")
          .attr("transform", function(d) {
            return "translate(" + [d.x, d.y] + ")rotate(" + d.rotate + ")";
          })
          .text(function(d) { return d.text; });
    }
}