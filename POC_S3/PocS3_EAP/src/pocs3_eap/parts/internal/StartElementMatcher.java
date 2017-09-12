package pocs3_eap.parts.internal;

import java.util.List;

import org.eclipse.e4.ui.model.application.MApplicationElement;
import org.eclipse.e4.ui.workbench.Selector;

/**
 * This is an implementation of a Selector that implements the existing 'findElements'. Clients may
 * subclass this and override the 'select' method in order to define custom filters.
 *
 * @since 1.1
 *
 */
public class StartElementMatcher implements Selector {
	private String id = null;
	private Class<?> clazz = null;
	private List<String> tagsToMatch = null;

	/**
	 * @param id
	 *            The elementId of the desired element
	 * @param clazz
	 *            The class specification of the desired element
	 * @param tagsToMatch
	 *            A list of tags which must <b>all</b> be specified on the desired element
	 *
	 */
	public StartElementMatcher(String id, Class<?> clazz, List<String> tagsToMatch) {
		this.id = id;
		this.clazz = clazz;
		this.tagsToMatch = tagsToMatch;
	}

	@Override
	public boolean select(MApplicationElement element) {
//	    System.out.println("element.getElementId() "+element.getElementId());
		if (this.id != null && !element.getElementId().startsWith(this.id)) {
			return false;
		}

		if (this.clazz != null && !(this.clazz.isInstance(element))) {
			return false;
		}

		if (this.tagsToMatch != null) {
			final List<String> elementTags = element.getTags();
			for (final String tag : this.tagsToMatch) {
				if (!elementTags.contains(tag)) {
					return false;
				}
			}
		}

		return true;
	}
}
