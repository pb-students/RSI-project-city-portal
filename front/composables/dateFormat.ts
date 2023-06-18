import f from 'dateformat'

export const dateFormat = (date: string | Date | number, format: string) => {
  if (typeof date === 'string') {
    date = new Date(date.replace(/\[UTC\]$/, ''))
  }

  return f(date, format)
}
