package ai.azure.openai.rag.workshop.backend.configuration;

import dev.langchain4j.model.azure.AzureOpenAiChatModel;
import dev.langchain4j.model.chat.ChatLanguageModel;
import jakarta.enterprise.inject.Produces;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import static java.time.Duration.ofSeconds;

public class ChatLanguageModelProducer {

  @ConfigProperty(name = "AZURE_OPENAI_KEY", defaultValue = "__dummy")
  String azureOpenAiKey;

  @ConfigProperty(name = "AZURE_OPENAI_URL")
  String azureOpenAiEndpoint;

  @ConfigProperty(name = "AZURE_OPENAI_DEPLOYMENT_NAME", defaultValue = "gpt-35-turbo")
  String azureOpenAiDeploymentName;

  @Produces
  public ChatLanguageModel chatLanguageModel() {

    // ICI ON APPELLE ENCORE le chat model qui répond aux réponses. Là on dépend encore de 
    // AZURE_OPENAI_URL=https://openai-proxy.thankfulforest-26a1f1e5.westeurope.azurecontainerapps.io/QDRANT_URL=http://localhost:6334
//  qui est dans le .env

    // Chercher dans la doc de langchain4j comment mettre le model ollama local de réponse au chat



    return AzureOpenAiChatModel.builder()
      .apiKey(azureOpenAiKey)
      .endpoint(azureOpenAiEndpoint)
      .deploymentName(azureOpenAiDeploymentName)
      .timeout(ofSeconds(60))
      .logRequestsAndResponses(true)
      .build();
  }

}

