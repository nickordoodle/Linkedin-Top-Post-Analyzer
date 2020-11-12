# Linkedin Top Post Analyzer
<Strong> Provides meaningful content suggestions to use
in your future LinkedIn Posts.</Strong>


![Product Name Screen Shot][product-screenshot]

## Table of Contents

* [About the Project](#about-the-project)
  * [Built With](#built-with)
* [Getting Started](#getting-started)
* [Contributing](#contributing)
* [Contact](#contact)



<!-- ABOUT THE PROJECT -->
## About The Project

Analyze content from a LinkedIn Profile. Determines which hashtags and keywords
were most effective toward increasing LinkedIn Posts' reach (how many people view, like and/or comment on your posts)
Gives back a set of the best hashtags and/or keywords to use based on the user's data source historical data.
<br><br>
NOTE: You will need to perform
your own data collecting in order to use this software.  Some methods of retrieval
are using LinkedIn's API, developing data collection script using
REST calls, writing your own webscraper or using a third party web scraper.
<br><br>
Third Party Software: [webscraper.io](https://webscraper.io/)
<br><br>
We used webscraper.io when we tested and sampled data. You can import this sitemap below 
and follow the instructions to test your own content.
```
{"_id":"linkedin","startUrl":["https://[YOUR LINKEDIN PROFILE URL]/detail/recent-activity/shares/"],"selectors":[{"id":"textpost","type":"SelectorText","parentSelectors":["_root"],"selector":"span.break-words","multiple":true,"regex":"","delay":0}]}
```

### Built With
This section should list any major frameworks that you built your project using. Leave any add-ons/plugins for the acknowledgements section. Here are a few examples.
* [JDK 14](https://www.oracle.com/java/technologies/javase/jdk14-archive-downloads.html)
* [JUnit 4.13](https://junit.org/junit4/)


<!-- GETTING STARTED -->
## Getting Started

Collect your data as described in [About the Project](#about-the-project).
Final CSV file format required should mimic the image below.
## CSV Data Format

![CSV Format][csv-format]

<!-- USAGE EXAMPLES -->
## Usage
//TODO include usage scrnshots
Use this space to show useful examples of how a project can be used. Additional screenshots, code examples and demos work well in this space. You may also link to more resources.

_For more examples, please refer to the [Documentation](https://example.com)_



<!-- CONTRIBUTING -->
## Contributing

Feel free to contribute, there are many features that can be added!

1. Fork the Project
2. Create your Feature Branch (`git checkout -b newfeature/ExampleNewFeature`)
3. Commit your Changes (`git commit -m 'Add some ExampleNewFeature'`)
4. Push to the Branch (`git push origin newfeature/ExampleNewFeature`)
5. Open a Pull Request


<!-- CONTACT -->
## Contact

[Project Link](https://github.com/nscherer30/Linkedin-Top-Post-Analyzer)
<br>
[Nick's Github](https://github.com/nscherer30)
<br>
[Jason's Github](https://github.com/jasonlightmanjohn)
<br>

<!-- ACKNOWLEDGEMENTS -->
## Acknowledgements
* [webscraper.io](https://webscraper.io/)




[linkedin-url-nick]: https://www.linkedin.com/in/nicholas-scherer/
[product-screenshot]: resources/linkedin-analyzer-usage-diagram.png
[csv-format]: resources/linkedin-analyzer-csv-format.png