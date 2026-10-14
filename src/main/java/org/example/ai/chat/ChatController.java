package org.example.ai.chat;

import org.example.ai.tool.CustomerTools;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatController {

    private final ChatClient chatClient;
    private final CustomerTools customerTools;

    public ChatController(ChatClient.Builder chatClientBuilder, CustomerTools customerTools) {
        this.chatClient = chatClientBuilder.build();
        this.customerTools = customerTools;
    }

    @GetMapping("/api/ai/chat")
    public String chat(
            @RequestParam String message) {

        return chatClient
                .prompt()
                .user(message)
                .tools(customerTools)
                .call()
                .content();
    }
}