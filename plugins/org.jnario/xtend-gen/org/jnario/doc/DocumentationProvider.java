package org.jnario.doc;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.documentation.IEObjectDocumentationProvider;

import com.google.common.base.Objects;
import com.google.inject.Inject;

@SuppressWarnings("all")
public class DocumentationProvider {
  private final IEObjectDocumentationProvider delegate;
  
  @Inject
  public DocumentationProvider(final IEObjectDocumentationProvider delegate) {
    this.delegate = delegate;
  }
  
  public String getDocumentation(final EObject eObject) {
    String _xblockexpression = null;
    {
      final String doc = this.delegate.getDocumentation(eObject);
      boolean _equals = Objects.equal(doc, null);
      if (_equals) {
        return null;
      }
      String _replaceAll = doc.replaceAll("\\\\/\\*", "/*");
      String _replaceAll_1 = _replaceAll.replaceAll("\\\\\\*/", "*/");
      _xblockexpression = (_replaceAll_1);
    }
    return _xblockexpression;
  }
}