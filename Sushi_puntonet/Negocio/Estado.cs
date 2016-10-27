using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Negocio
{
    public enum Estado
    {
        SOLICITADO = 1, EN_PROCESO = 2, EN_CAMINO = 3, LISTO_EN_LOCAL = 4, ANULADO = 5
    }
}
