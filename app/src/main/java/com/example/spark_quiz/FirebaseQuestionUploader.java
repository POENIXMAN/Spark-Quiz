package com.example.spark_quiz;


import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Arrays;
import java.util.List;

public class FirebaseQuestionUploader {
    public static void uploadQuestions() {
        // Initialize Firestore
        FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();



        List<String> optionsQuestion3 = Arrays.asList("Albert Einstein", "Isaac Newton", "Galileo Galilei");
        Question question3 = new Question("Who formulated the laws of motion?", "Science", "Isaac Newton", optionsQuestion3);
        firebaseFirestore.collection("questions").add(question3);

        // Question 4
        List<String> optionsQuestion4 = Arrays.asList("Leonardo da Vinci", "Vincent van Gogh", "Pablo Picasso");
        Question question4 = new Question("Which artist is known for painting the Mona Lisa?", "Art", "Leonardo da Vinci", optionsQuestion4);
        firebaseFirestore.collection("questions").add(question4);

        // ...

// Question 5
        List<String> optionsQuestion5 = Arrays.asList("Marie Curie", "Albert Einstein", "Niels Bohr");
        Question question5 = new Question("Who won two Nobel Prizes in two different scientific fields?", "Science", "Marie Curie", optionsQuestion5);
        firebaseFirestore.collection("questions").add(question5);

// Question 6
        List<String> optionsQuestion6 = Arrays.asList("Michael Jackson", "Elvis Presley", "The Beatles");
        Question question6 = new Question("Which artist is known as the 'King of Pop'?", "Pop-Culture", "Michael Jackson", optionsQuestion6);
        firebaseFirestore.collection("questions").add(question6);

// Question 7
        List<String> optionsQuestion7 = Arrays.asList("World War I", "American Civil War", "Vietnam War");
        Question question7 = new Question("In which war did the Battle of Gettysburg take place?", "History", "American Civil War", optionsQuestion7);
        firebaseFirestore.collection("questions").add(question7);

// Question 8
        List<String> optionsQuestion8 = Arrays.asList("Mount Everest", "K2", "Kangchenjunga");
        Question question8 = new Question("Which is the third-highest mountain in the world?", "Geography", "Kangchenjunga", optionsQuestion8);
        firebaseFirestore.collection("questions").add(question8);

// Question 9
        List<String> optionsQuestion9 = Arrays.asList("Madrid", "Rome", "Berlin");
        Question question9 = new Question("What is the capital city of Spain?", "Geography", "Madrid", optionsQuestion9);
        firebaseFirestore.collection("questions").add(question9);

// Question 10
        List<String> optionsQuestion10 = Arrays.asList("William Shakespeare", "Emily Brontë", "Jane Austen");
        Question question10 = new Question("Who wrote the novel 'Wuthering Heights'?", "Pop-Culture", "Emily Brontë", optionsQuestion10);
        firebaseFirestore.collection("questions").add(question10);

// ...
// ...

// Question 11
        List<String> optionsQuestion11 = Arrays.asList("Leon Trotsky", "Joseph Stalin", "Vladimir Lenin");
        Question question11 = new Question("Who led the Bolshevik Party during the Russian Revolution of 1917?", "History", "Vladimir Lenin", optionsQuestion11);
        firebaseFirestore.collection("questions").add(question11);

// Question 12
        List<String> optionsQuestion12 = Arrays.asList("Niagara Falls", "Victoria Falls", "Angel Falls");
        Question question12 = new Question("Which waterfall is the highest in the world?", "Geography", "Angel Falls", optionsQuestion12);
        firebaseFirestore.collection("questions").add(question12);

// Question 13
        List<String> optionsQuestion13 = Arrays.asList("Curiosity", "Opportunity", "Spirit");
        Question question13 = new Question("Which rover discovered evidence of past water on Mars?", "Science", "Curiosity", optionsQuestion13);
        firebaseFirestore.collection("questions").add(question13);

// Question 14
        List<String> optionsQuestion14 = Arrays.asList("Vincent van Gogh", "Claude Monet", "Pablo Picasso");
        Question question14 = new Question("Who is considered the founder of Impressionism in art?", "Art", "Claude Monet", optionsQuestion14);
        firebaseFirestore.collection("questions").add(question14);

// Question 15
        List<String> optionsQuestion15 = Arrays.asList("J.K. Rowling", "J.R.R. Tolkien", "George R.R. Martin");
        Question question15 = new Question("Who is the author of the 'Harry Potter' series?", "Pop-Culture", "J.K. Rowling", optionsQuestion15);
        firebaseFirestore.collection("questions").add(question15);

// Question 16
        List<String> optionsQuestion16 = Arrays.asList("Isaac Newton", "Albert Einstein", "Galileo Galilei");
        Question question16 = new Question("Who formulated the theory of general relativity?", "Science", "Albert Einstein", optionsQuestion16);
        firebaseFirestore.collection("questions").add(question16);

// Question 17
        List<String> optionsQuestion17 = Arrays.asList("The Great Wall of China", "The Pyramids of Giza", "Machu Picchu");
        Question question17 = new Question("Which is one of the Seven Wonders of the Ancient World?", "History", "The Pyramids of Giza", optionsQuestion17);
        firebaseFirestore.collection("questions").add(question17);

// Question 18
        List<String> optionsQuestion18 = Arrays.asList("Himalayas", "Andes", "Rocky Mountains");
        Question question18 = new Question("Which mountain range is the longest in the world?", "Geography", "Andes", optionsQuestion18);
        firebaseFirestore.collection("questions").add(question18);

// Question 19
        List<String> optionsQuestion19 = Arrays.asList("Rosa Parks", "Malcolm X", "Martin Luther King Jr.");
        Question question19 = new Question("Who is known for leading the Montgomery Bus Boycott during the Civil Rights Movement?", "History", "Martin Luther King Jr.", optionsQuestion19);
        firebaseFirestore.collection("questions").add(question19);

// Question 20
        List<String> optionsQuestion20 = Arrays.asList("Berlin", "Vienna", "Paris");
        Question question20 = new Question("In which European city did the famous Berlin Airlift take place?", "History", "Berlin", optionsQuestion20);
        firebaseFirestore.collection("questions").add(question20);

// ...

        // ...

// Question 21
        List<String> optionsQuestion21 = Arrays.asList("Frida Kahlo", "Salvador Dalí", "Pablo Picasso");
        Question question21 = new Question("Which artist is known for surrealist paintings like 'The Persistence of Memory'?", "Art", "Salvador Dalí", optionsQuestion21);
        firebaseFirestore.collection("questions").add(question21);

// Question 22
        List<String> optionsQuestion22 = Arrays.asList("Charles Darwin", "Gregor Mendel", "Louis Pasteur");
        Question question22 = new Question("Who is known as the father of modern genetics?", "Science", "Gregor Mendel", optionsQuestion22);
        firebaseFirestore.collection("questions").add(question22);

// Question 23
        List<String> optionsQuestion23 = Arrays.asList("Mozart", "Beethoven", "Bach");
        Question question23 = new Question("Which composer is famous for his 'Moonlight Sonata'?", "Art", "Beethoven", optionsQuestion23);
        firebaseFirestore.collection("questions").add(question23);

// Question 24
        List<String> optionsQuestion24 = Arrays.asList("Antarctica", "Arctic", "Greenland");
        Question question24 = new Question("Which is the largest desert in the world?", "Geography", "Antarctica", optionsQuestion24);
        firebaseFirestore.collection("questions").add(question24);

// Question 25
        List<String> optionsQuestion25 = Arrays.asList("The Renaissance", "The Enlightenment", "The Industrial Revolution");
        Question question25 = new Question("Which historical period saw a rebirth of art, culture, and learning in Europe?", "History", "The Renaissance", optionsQuestion25);
        firebaseFirestore.collection("questions").add(question25);

// Question 26
        List<String> optionsQuestion26 = Arrays.asList("The Great Barrier Reef", "The Amazon Rainforest", "The Serengeti");
        Question question26 = new Question("Which is the largest coral reef system in the world?", "Geography", "The Great Barrier Reef", optionsQuestion26);
        firebaseFirestore.collection("questions").add(question26);

// Question 27
        List<String> optionsQuestion27 = Arrays.asList("Marie Antoinette", "Cleopatra", "Queen Elizabeth I");
        Question question27 = new Question("Which historical figure is often associated with the phrase 'Let them eat cake'?", "History", "Marie Antoinette", optionsQuestion27);
        firebaseFirestore.collection("questions").add(question27);

// Question 28
        List<String> optionsQuestion28 = Arrays.asList("Leonardo da Vinci", "Michelangelo", "Raphael");
        Question question28 = new Question("Who painted the ceiling of the Sistine Chapel?", "Art", "Michelangelo", optionsQuestion28);
        firebaseFirestore.collection("questions").add(question28);

// Question 29
        List<String> optionsQuestion29 = Arrays.asList("Apollo 11", "Apollo 13", "Apollo 17");
        Question question29 = new Question("Which Apollo mission was the first to land humans on the Moon?", "Science", "Apollo 11", optionsQuestion29);
        firebaseFirestore.collection("questions").add(question29);

// Question 30
        List<String> optionsQuestion30 = Arrays.asList("The Nile", "The Amazon", "The Mississippi");
        Question question30 = new Question("Which is the longest river in the world?", "Geography", "The Nile", optionsQuestion30);
        firebaseFirestore.collection("questions").add(question30);

// ...
// ...

// Question 31
        List<String> optionsQuestion31 = Arrays.asList("The Eiffel Tower", "The Colosseum", "The Great Wall of China");
        Question question31 = new Question("Which iconic landmark is located in Paris, France?", "Geography", "The Eiffel Tower", optionsQuestion31);
        firebaseFirestore.collection("questions").add(question31);

// Question 32
        List<String> optionsQuestion32 = Arrays.asList("Sir Isaac Newton", "Stephen Hawking", "Albert Einstein");
        Question question32 = new Question("Who developed the theory of black holes in astrophysics?", "Science", "Stephen Hawking", optionsQuestion32);
        firebaseFirestore.collection("questions").add(question32);

// Question 33
        List<String> optionsQuestion33 = Arrays.asList("Vincent van Gogh", "Edvard Munch", "Claude Monet");
        Question question33 = new Question("Which artist painted 'The Scream'?", "Art", "Edvard Munch", optionsQuestion33);
        firebaseFirestore.collection("questions").add(question33);

// Question 34
        List<String> optionsQuestion34 = Arrays.asList("The Great Wall of China", "The Grand Canyon", "The Great Barrier Reef");
        Question question34 = new Question("Which wonder of the world is visible from space?", "Geography", "The Great Wall of China", optionsQuestion34);
        firebaseFirestore.collection("questions").add(question34);

// Question 35
        List<String> optionsQuestion35 = Arrays.asList("William the Conqueror", "Richard the Lionheart", "King John");
        Question question35 = new Question("Which English king signed the Magna Carta in 1215?", "History", "King John", optionsQuestion35);
        firebaseFirestore.collection("questions").add(question35);

// Question 36
        List<String> optionsQuestion36 = Arrays.asList("Cleopatra", "Queen Victoria", "Elizabeth I");
        Question question36 = new Question("Which queen ruled during the Elizabethan Era in England?", "History", "Elizabeth I", optionsQuestion36);
        firebaseFirestore.collection("questions").add(question36);

// Question 37
        List<String> optionsQuestion37 = Arrays.asList("Mount Kilimanjaro", "Mount Fuji", "Mount McKinley");
        Question question37 = new Question("Which is the highest mountain in Africa?", "Geography", "Mount Kilimanjaro", optionsQuestion37);
        firebaseFirestore.collection("questions").add(question37);

// Question 38
        List<String> optionsQuestion38 = Arrays.asList("The Mona Lisa", "Starry Night", "The Last Supper");
        Question question38 = new Question("Which famous painting was created by Leonardo da Vinci?", "Art", "The Mona Lisa", optionsQuestion38);
        firebaseFirestore.collection("questions").add(question38);

// Question 39
        List<String> optionsQuestion39 = Arrays.asList("Marie Curie", "Rosalind Franklin", "Barbara McClintock");
        Question question39 = new Question("Who discovered the structure of DNA along with James Watson?", "Science", "Rosalind Franklin", optionsQuestion39);
        firebaseFirestore.collection("questions").add(question39);

// Question 40
        List<String> optionsQuestion40 = Arrays.asList("The Beatles", "The Rolling Stones", "Led Zeppelin");
        Question question40 = new Question("Which band is often considered the 'Greatest Rock and Roll Band in the World'?", "Pop-Culture", "The Rolling Stones", optionsQuestion40);
        firebaseFirestore.collection("questions").add(question40);

// ...
// ...

// Question 41
        List<String> optionsQuestion41 = Arrays.asList("The Great Wall of China", "Machu Picchu", "Petra");
        Question question41 = new Question("Which archaeological site is located in the Andes Mountains?", "History", "Machu Picchu", optionsQuestion41);
        firebaseFirestore.collection("questions").add(question41);

// Question 42
        List<String> optionsQuestion42 = Arrays.asList("The Pacific Ocean", "The Indian Ocean", "The Atlantic Ocean");
        Question question42 = new Question("Which ocean is the largest on Earth?", "Geography", "The Pacific Ocean", optionsQuestion42);
        firebaseFirestore.collection("questions").add(question42);

// Question 43
        List<String> optionsQuestion43 = Arrays.asList("Marie Curie", "Enrico Fermi", "Niels Bohr");
        Question question43 = new Question("Who is known as the father of nuclear physics?", "Science", "Enrico Fermi", optionsQuestion43);
        firebaseFirestore.collection("questions").add(question43);

// Question 44
        List<String> optionsQuestion44 = Arrays.asList("Vincent van Gogh", "Edgar Degas", "Claude Monet");
        Question question44 = new Question("Which artist is associated with the Impressionist movement?", "Art", "Claude Monet", optionsQuestion44);
        firebaseFirestore.collection("questions").add(question44);

// Question 45
        List<String> optionsQuestion45 = Arrays.asList("The Sahara", "The Kalahari", "The Gobi");
        Question question45 = new Question("Which desert is the largest hot desert in the world?", "Geography", "The Sahara", optionsQuestion45);
        firebaseFirestore.collection("questions").add(question45);

// Question 46
        List<String> optionsQuestion46 = Arrays.asList("The Cold War", "The Korean War", "The Vietnam War");
        Question question46 = new Question("Which war is often referred to as the 'Forgotten War'?", "History", "The Korean War", optionsQuestion46);
        firebaseFirestore.collection("questions").add(question46);

// Question 47
        List<String> optionsQuestion47 = Arrays.asList("Austria", "Hungary", "Switzerland");
        Question question47 = new Question("Which European country is known for the Alps?", "Geography", "Switzerland", optionsQuestion47);
        firebaseFirestore.collection("questions").add(question47);

// Question 48
        List<String> optionsQuestion48 = Arrays.asList("Georgia O'Keeffe", "Jackson Pollock", "Andy Warhol");
        Question question48 = new Question("Which artist is associated with the American Modernism movement?", "Art", "Georgia O'Keeffe", optionsQuestion48);
        firebaseFirestore.collection("questions").add(question48);

// Question 49
        List<String> optionsQuestion49 = Arrays.asList("Nikola Tesla", "Thomas Edison", "Alexander Graham Bell");
        Question question49 = new Question("Who is known for inventing the alternating current (AC) electrical system?", "Science", "Nikola Tesla", optionsQuestion49);
        firebaseFirestore.collection("questions").add(question49);

// Question 50
        List<String> optionsQuestion50 = Arrays.asList("The Roman Empire", "The Ottoman Empire", "The Byzantine Empire");
        Question question50 = new Question("Which empire was known as the 'Eastern Roman Empire'?", "History", "The Byzantine Empire", optionsQuestion50);
        firebaseFirestore.collection("questions").add(question50);

// ...



    }


}
