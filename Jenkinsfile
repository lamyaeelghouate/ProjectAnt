// Jenkinsfile (Declarative Pipeline) pour le projet Ant

pipeline {
    // Définit où le pipeline s'exécutera. 'any' signifie sur n'importe quel agent disponible.
    agent any

    // Définit les outils à mettre à disposition dans le PATH pendant l'exécution
    tools {
        // Assurez-vous que 'Ant_1.10.x' correspond EXACTEMENT au nom configuré dans Jenkins -> Outils
        ant 'Ant_1.10.15'
        // Ajoutez un JDK si votre projet en requiert un spécifique et qu'il est configuré dans Jenkins -> Outils
        // jdk 'AdoptOpenJDK-11'
    }

    stages {
        // Étape 1 : Récupération du code source
        stage('Checkout') {
            steps {
                // Nettoie l'espace de travail avant le checkout (nécessite Workspace Cleanup Plugin)
                cleanWs()
                // Récupère le code depuis le dépôt configuré dans le job Jenkins
                // Les détails (URL, credentials) seront pris depuis la configuration du job Pipeline
                checkout scm
                echo 'Code source récupéré.'
            }
        }

        // Étape 2 : Construction avec Ant
        stage('Build') {
            steps {
                echo "Début du build Ant..."
                // Exécute Ant. Utilise sh pour Linux/macOS, bat pour Windows.
                // La directive 'tools' a ajouté l'exécutable Ant au PATH.
                // Adaptez les cibles (targets) à votre build.xml
                // Si build.xml n'est pas à la racine : ant(buildFile: 'chemin/vers/build.xml', targets: 'clean compile test package')
                bat 'ant init build run test doc jar' // Ou 'bat "ant clean compile test package"' pour Windows
                echo 'Build Ant terminé.'
            }
        }

        // Étape 3 : Archivage des artefacts
        stage('Archive Artifacts') {
            steps {
                echo "Archivage des artefacts..."
                // Archive les fichiers produits par le build Ant
                // Adaptez le pattern à vos artefacts réels (ex: 'dist/**/*.jar', 'build/libs/*.war')
                archiveArtifacts artifacts: 'dist/**/*.jar', fingerprint: true
                echo "Artefacts archivés."
            }
        }
    }

    // Actions exécutées à la fin du pipeline, quel que soit le résultat (success, failure, etc.)
    post {
        always {
            echo 'Pipeline terminé.'
            // Optionnel: Nettoyer l'espace de travail après le build
            // cleanWs()
        }
        success {
            echo 'Build réussi !'
            // Envoyer une notification de succès, etc.
        }
        failure {
            echo 'Build échoué !'
            // Envoyer une notification d'échec, etc.
        }
    }
}
