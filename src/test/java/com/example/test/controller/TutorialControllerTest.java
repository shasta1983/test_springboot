package com.example.test.controller;

import com.example.test.entity.Tutorial;
import com.example.test.repository.TutorialRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Optional;


import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
class TutorialControllerTest {

    private MockMvc mockMvc;

    @Mock
    TutorialRepository tutorialRepository;

    @Mock
    Tutorial tutorial;

    @InjectMocks
    TutorialController tutorialController;

    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(tutorialController).build();

    }

    @Test
    void getAllTutorials() throws Exception {
        Tutorial tutorial = new Tutorial("test", "test description", true);
        tutorial.setId(1L);

        Mockito.when(tutorialRepository.findById(1L)).thenReturn(Optional.of(tutorial));
        mockMvc.perform(MockMvcRequestBuilders.get("tutorials/"+1L))
                .andExpect(status().isOk());
        Mockito.verify(tutorialRepository, times(1)).getReferenceById(eq(tutorial.getId()));
        }

    @Test
    void getTutorialById() {

    }

    @Test
    void createTutorial() {
    }

    @Test
    void updateTutorial() {
    }

    @Test
    void deleteTutorial() {
    }

    @Test
    void deleteAllTutorials() {
    }

    @Test
    void findByPublished() {
    }
}