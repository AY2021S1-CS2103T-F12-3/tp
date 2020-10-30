package seedu.address.testutil;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import seedu.address.logic.commands.modulelistcommands.EditModuleDescriptor;
import seedu.address.model.module.ModularCredits;
import seedu.address.model.module.Module;
import seedu.address.model.module.ModuleName;
import seedu.address.model.module.grade.GradePoint;
import seedu.address.model.tag.Tag;


/**
 * A utility class to help with building EditModuleDescriptor objects.
 */
public class EditModuleDescriptorBuilder {

    private EditModuleDescriptor descriptor;

    public EditModuleDescriptorBuilder() {
        descriptor = new EditModuleDescriptor();
    }

    public EditModuleDescriptorBuilder(EditModuleDescriptor descriptor) {
        this.descriptor = new EditModuleDescriptor(descriptor);
    }

    /**
     * Returns an {@code EditModuleDescriptor} with fields containing {@code module}'s details
     */
    public EditModuleDescriptorBuilder(Module module) {
        descriptor = new EditModuleDescriptor();
        descriptor.setModuleName(module.getName());
        // descriptor.setZoomLink(module.getLink());
        descriptor.setModularCredits(module.getModularCredits());
        if (module.getGradeTracker().getGradePoint().isPresent()) {
            descriptor.setGradePoint(module.getGradeTracker().getGradePoint().get());
        }
        descriptor.setTags(module.getTags());
    }

    /**
     * Sets the {@code Name} of the {@code EditModuleDescriptor} that we are building.
     */
    public EditModuleDescriptorBuilder withName(String name) {
        descriptor.setModuleName(new ModuleName(name));
        return this;
    }

    /**
     * Sets the {@code ZoomLink} of the {@code EditModuleDescriptor} that we are building.
     */
    public EditModuleDescriptorBuilder withZoomLink(String zoomLink) {
        // descriptor.setZoomLink(new ZoomLink(zoomLink));
        return this;
    }

    /**
     * Parses the {@code tags} into a {@code Set<Tag>} and set it to the {@code EditModuleDescriptor}
     * that we are building.
     */
    public EditModuleDescriptorBuilder withTags(String... tags) {
        Set<Tag> tagSet = Stream.of(tags).map(Tag::new).collect(Collectors.toSet());
        descriptor.setTags(tagSet);
        return this;
    }
     /**
     * Sets the {@code ModularCredits} of the {@code EditModuleDescriptor} that we are building.
     */
     public EditModuleDescriptorBuilder withMc(double mc) {
         descriptor.setModularCredits(new ModularCredits(mc));
         return this;
     }
     /**
     * Sets the {@code Tags} of the {@code EditModuleDescriptor} that we are building.
     * */
    public EditModuleDescriptorBuilder withTags(String tag) {
        Set<Tag> updatedTag = new HashSet<Tag>();
        updatedTag.add(new Tag(tag));
        return this;
    }

    /**
     * Sets the {@code GradePoint} of the {@code EditModuleDescriptor} that we are building.
     */
    public EditModuleDescriptorBuilder withGradePoint(double gradePoint) {
        descriptor.setGradePoint(new GradePoint(gradePoint));
        return this;
    }
    public EditModuleDescriptor build() {
        return descriptor;
    }
}
