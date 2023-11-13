//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.3.1 
// Visite <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2023.11.13 a las 10:54:57 AM CET 
//


package generated;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="pelicula" maxOccurs="unbounded" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="titulo" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                   &lt;element name="sala" type="{http://www.w3.org/2001/XMLSchema}byte"/&gt;
 *                   &lt;element name="precio" type="{http://www.w3.org/2001/XMLSchema}float"/&gt;
 *                 &lt;/sequence&gt;
 *                 &lt;attribute name="calificacion" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "pelicula"
})
@XmlRootElement(name = "cine")
public class Cine {

    protected List<Cine.Pelicula> pelicula;

    /**
     * Gets the value of the pelicula property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the pelicula property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPelicula().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Cine.Pelicula }
     * 
     * 
     */
    public List<Cine.Pelicula> getPelicula() {
        if (pelicula == null) {
            pelicula = new ArrayList<Cine.Pelicula>();
        }
        return this.pelicula;
    }


    /**
     * <p>Clase Java para anonymous complex type.
     * 
     * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="titulo" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *         &lt;element name="sala" type="{http://www.w3.org/2001/XMLSchema}byte"/&gt;
     *         &lt;element name="precio" type="{http://www.w3.org/2001/XMLSchema}float"/&gt;
     *       &lt;/sequence&gt;
     *       &lt;attribute name="calificacion" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "titulo",
        "sala",
        "precio"
    })
    public static class Pelicula {

        @XmlElement(required = true)
        protected String titulo;
        protected byte sala;
        protected float precio;
        @XmlAttribute(name = "calificacion")
        protected String calificacion;

        /**
         * Obtiene el valor de la propiedad titulo.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTitulo() {
            return titulo;
        }

        /**
         * Define el valor de la propiedad titulo.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTitulo(String value) {
            this.titulo = value;
        }

        /**
         * Obtiene el valor de la propiedad sala.
         * 
         */
        public byte getSala() {
            return sala;
        }

        /**
         * Define el valor de la propiedad sala.
         * 
         */
        public void setSala(byte value) {
            this.sala = value;
        }

        /**
         * Obtiene el valor de la propiedad precio.
         * 
         */
        public float getPrecio() {
            return precio;
        }

        /**
         * Define el valor de la propiedad precio.
         * 
         */
        public void setPrecio(float value) {
            this.precio = value;
        }

        /**
         * Obtiene el valor de la propiedad calificacion.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCalificacion() {
            return calificacion;
        }

        /**
         * Define el valor de la propiedad calificacion.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCalificacion(String value) {
            this.calificacion = value;
        }

    }

}
