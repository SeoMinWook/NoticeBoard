package min.resource;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ws/comment")
public class WSCommentResource {

	@RequestMapping(method=RequestMethod.GET)
	public Object findComments(
			@RequestParam("noticeId") int noticeId
		) {
		List<String> list = new ArrayList<String>();
		list.add("서민욱");
		list.add("허장회");
		return list;
	}

}
