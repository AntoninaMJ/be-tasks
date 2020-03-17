package pl.antonina.tasks.child;

import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/children")
public class ChildController {

    private final ChildService childService;

    public ChildController(ChildService childService) {
        this.childService = childService;
    }

    @GetMapping("/byParent")
    public List<ChildView> getChildrenByParent(@ApiIgnore Principal parentPrincipal) {
        return childService.getChildrenByParent(parentPrincipal);
    }

    @GetMapping
    public ChildView getChild(@ApiIgnore Principal parentPrincipal) {
        return childService.getChild(parentPrincipal);
    }

    @GetMapping("/{childId}")
    public ChildView getChild(@PathVariable long childId) {
        return childService.getChild(childId);
    }

    @PostMapping
    public void addChild(@ApiIgnore Principal parentPrincipal, @RequestBody ChildData childData) {
        childService.addChild(parentPrincipal, childData);
    }

    @PutMapping("/{childId}")
    public void updateChild(@PathVariable long childId, @RequestBody ChildData childData) {
        childService.updateChild(childId, childData);
    }

    @DeleteMapping("/{childId}")
    public void deleteChild(@PathVariable long childId) {
        childService.deleteChild(childId);
    }
}