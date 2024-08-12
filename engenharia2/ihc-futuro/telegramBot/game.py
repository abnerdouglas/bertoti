import telebot
import random
import os 
from dotenv import load_dotenv

load_dotenv()

TOKEN = os.getenv("TOKEN")

bot = telebot.TeleBot(TOKEN)

# Dicionário de perguntas, respostas e dicas
perguntas_respostas_dicas = {

    # Perguntas sobre games
    "Qual é o nome do encanador italiano da Nintendo?": {
        "resposta": "mario", 
        "dica": "Ele é conhecido por usar boné vermelho e macacão azul."
    },
    
    "Qual é o jogo mais vendido de todos os tempos?": {
        "resposta": "minecraft", 
        "dica": "É um jogo de construção e sobrevivência."
    },

    "Em que ano foi lançado o primeiro PlayStation da Sony?": {
        "resposta": "1994", 
        "dica": "Foi lançado na década de 1990."
    },

    "Qual é o nome do estúdio de desenvolvimento de Grand Theft Auto V?": {
        "resposta": "rockstar games", 
        "dica": "Eles também são conhecidos por criar a série Red Dead."
    },

    "Qual é o nome do protagonista do jogo 'The Grand Theft Auto IV'?": {
        "resposta": "niko bellic", 
        "dica": "Ele é um imigrante do leste europeu em busca do 'sonho americano'."
    },
    
    # Perguntas sobre geografia
    "Qual é o país mais populoso do mundo?": {
        "resposta": "china", 
        "dica": "É o país com a maior população do mundo e está localizado na Ásia."
    },

    "Qual é o nome da maior reserva de água doce do mundo, localizada no Brasil?": {
        "resposta": "aquífero guarani", 
        "dica": "É uma imensa reserva subterrânea que abrange parte do Brasil, Paraguai, Uruguai e Argentina."
    },

    "Qual é o nome do país que possui o maior número de vulcões ativos?": {
        "resposta": "indonésia", 
        "dica": "É um país do sudeste asiático composto por milhares de ilhas e abriga uma grande quantidade de vulcões ativos."
    },

    "Qual é o nome da cidade mais alta do mundo, localizada na região dos Andes?": {
        "resposta": "la paz", 
        "dica": "É a capital administrativa da Bolívia e está situada em um vale cercado por montanhas dos Andes."
    },

    # Perguntas sobre história
     "Qual foi o evento que marcou o fim da Idade Média e o início da Idade Moderna na Europa?": {
        "resposta": "queda de constantinopla",
        "dica": "Este evento ocorreu em 1453 e resultou na ascensão do Império Otomano e no fim do Império Bizantino."
    },
    
    "Qual foi o evento que desencadeou a entrada dos Estados Unidos na Segunda Guerra Mundial?": {
        "resposta": "ataque a pearl harbor",
        "dica": "Este ataque japonês à base naval de Pearl Harbor, no Havaí, em 7 de dezembro de 1941, levou os Estados Unidos a declarar guerra ao Japão e entrar na Segunda Guerra Mundial."
    },

    "Quem foi o líder militar e político que liderou a Revolução Cubana em 1959 e se tornou o líder de Cuba até 2008?": {
        "resposta": "fidel castro",
        "dica": "Ele foi um líder carismático e controverso que desafiou os Estados Unidos e implementou um regime comunista em Cuba após a revolução."
    }
}

pergunta_atual = None

# Função para iniciar o menu
@bot.message_handler(commands=['start'])
def handle_start(message):
    chat_id = message.chat.id
    boas_vindas = "Bem-vindo ao Bot de Perguntas sobre Jogos!\n\n" \
                  "O Bot possui conhecimentos em games, geografia e história."\
                  "Para começar, use o comando /play.\n\n" \
                  "Aqui estão alguns comandos disponíveis:\n" \
                  "/play - Começa o jogo\n" \
                  "/dica - Mostra uma dica referente a pergunta da vez"
    bot.send_message(chat_id, boas_vindas)

# Função para iniciar o jogo
@bot.message_handler(commands=['play'])
def handle_play(message):
    chat_id = message.chat.id
    global pergunta_atual
    pergunta_atual = random.choice(list(perguntas_respostas_dicas.keys()))
    bot.send_message(chat_id, pergunta_atual)

# Função para fornecer dica
@bot.message_handler(commands=['dica'])
def handle_dica(message):
    chat_id = message.chat.id
    global pergunta_atual
    if pergunta_atual in perguntas_respostas_dicas:
        dica = perguntas_respostas_dicas[pergunta_atual]["dica"]
        bot.send_message(chat_id, f"Dica: {dica}")
    else:
        bot.send_message(chat_id, "Não há dica disponível para esta pergunta.")

# Função para lidar com as respostas
@bot.message_handler(func=lambda message: True)
def handle_message(message):
    chat_id = message.chat.id
    resposta = message.text.lower()

    global pergunta_atual

    # Verificar se há uma pergunta em andamento
    if pergunta_atual:
        resposta_correta = perguntas_respostas_dicas[pergunta_atual]["resposta"]

        # Verificar se a resposta está correta
        if resposta == resposta_correta:
            bot.send_message(chat_id, "Resposta correta! 🎉")
            pergunta_atual = None
        else:
            bot.send_message(chat_id, "Resposta incorreta. Tente novamente ou peça uma dica com /dica.")
    else:
        bot.send_message(chat_id, "Por favor, use o comando /play para começar a jogar.")

# Mensagem de ajuda
@bot.message_handler(commands=['help'])
def handle_help(message):
    chat_id = message.chat.id
    ajuda = "Este bot faz perguntas sobre jogos. Para começar, use o comando /play.\n\n" \
            "Para responder às perguntas, basta digitar a resposta.\n\n" \
            "Você pode pedir uma dica para a pergunta atual usando o comando /dica.\n\n" \
            "Aqui estão alguns comandos disponíveis:\n" \
            "/play - Começa o jogo\n" \
            "/dica - Obtém uma dica para a pergunta atual\n" 
    bot.send_message(chat_id, ajuda)

# Inicialização do bot
bot.polling()
