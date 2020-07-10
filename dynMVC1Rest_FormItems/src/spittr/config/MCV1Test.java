package spittr.config;

import static org.mockito.Mockito.*;
import static
org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static
org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static
org.springframework.test.web.servlet.setup.MockMvcBuilders.*;
import static  org.junit.Assert.*;
import static  org.junit.matchers.JUnitMatchers.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.view.InternalResourceView;

import spittr.*;
import spittr.data.*;
import spittr.web.HomeController;
import spittr.web.SpitterController;
public class MCV1Test {
/*@Test
public void testHomePage() throws Exception {
HomeController controller = new HomeController();
MockMvc mockMvc =
standaloneSetup(controller).build();
mockMvc.perform(get("/"))
.andExpect(view().name("home"));
}


@Test
public void shouldShowRecentSpittles() throws Exception {
List<Spittle> expectedSpittles = createSpittleList(20);
AppRepository mockRepository =mock(AppRepository.class);
when(mockRepository.findSpittles(Long.MAX_VALUE, 20)).thenReturn(expectedSpittles);

SpittleController controller =
new SpittleController(mockRepository);
MockMvc mockMvc = standaloneSetup(controller)
.setSingleView(
new InternalResourceView("/WEB-INF/views/spittles.jsp"))
.build();
mockMvc.perform(get("/spittles"))
.andExpect(view().name("spittles"))
.andExpect(model().attributeExists("spittleList"))
.andExpect(model().attribute("spittleList",
hasItems(expectedSpittles.toArray())));
}

private List<Spittle> createSpittleList(int count) {
List<Spittle> spittles = new ArrayList<Spittle>();
for (int i=0; i < count; i++) {
spittles.add(new Spittle("Spittle " + i, new Date()));
}
return spittles;
}
*/

@Test
public void shouldShowRegistration() throws Exception {
SpitterController controller = new SpitterController();
MockMvc mockMvc = standaloneSetup(controller).build();
mockMvc.perform(get("/spitter/register"))
.andExpect(view().name("registerForm"));
}


}