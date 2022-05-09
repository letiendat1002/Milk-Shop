<?php 
    $conn = mysqli_connect('localhost',  'root', '', 'dataonline');
    $host ="localhost";
    $user ="root";
    $pass ="";
    $database="dataonline";
    mysqli_set_charset($conn,'utf8');

    if($conn){
        echo"Connected";
    }
?>