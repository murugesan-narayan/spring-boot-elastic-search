### spring Boot Elastic Search

    This application demonstrates how to use elastic search with spring boot

To Pull and Run Elastic Search:
   
    docker pull elasticsearch:7.6.2
    docker run -d -p 9200:9200 -e "discovery.type=single-node" elasticsearch:7.6.2

To Build Image and Push:
    Jib plugin used to create docker image and pushed to Docker Hub.

    mvn compile jib:build
    
To Run Container:
    
    docker pull docker4muru/spring-boot-elastic-search
    docker run -p 10091:10091 --name sbelasticsearch docker4muru/spring-boot-elastic-search
    
To Test:

   Run the [test](src/test/java/com/muru/elastic/search/repository/ArticleRepositoryTest.java)
